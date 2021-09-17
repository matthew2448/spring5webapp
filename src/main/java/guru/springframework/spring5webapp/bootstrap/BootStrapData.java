package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthRepository authRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthRepository authRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authRepository = authRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher p = new Publisher();
        p.setName("P Publishing");
        p.setCity("Here, Now");
        p.setState("NC");
        p.setAddressLine("1234 Here");

        publisherRepository.save(p);

        System.out.println("Publisher Count " + publisherRepository.count());


        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123N75L8");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(p);
        p.getBooks().add(ddd);

        authRepository.save(eric); bookRepository.save(ddd);
        publisherRepository.save(p);

        Author non = new Author("Berry","Bob");
        Book cc = new Book("Comain Criven Cesign", "123N75L9");
        eric.getBooks().add(cc);
        ddd.getAuthors().add(non);

        authRepository.save(non); bookRepository.save(cc);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher's # of books: " + p.getBooks().size());

    }
}
