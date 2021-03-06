package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Author, Long> {
}
