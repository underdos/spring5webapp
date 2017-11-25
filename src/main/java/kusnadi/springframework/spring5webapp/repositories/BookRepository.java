package kusnadi.springframework.spring5webapp.repositories;

import kusnadi.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
