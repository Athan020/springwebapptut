package athandile.springFrameowrk.springwebapp.repositories;

import athandile.springFrameowrk.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {

    @Override
    <S extends Book> S save(S s);

    @Override
    Iterable<Book> findAllById(Iterable<Long> iterable);

    @Override
    Optional<Book> findById(Long aLong);
}
