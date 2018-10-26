package athandile.springFrameowrk.springwebapp.repositories;

import athandile.springFrameowrk.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

 public interface AuthorRepository extends CrudRepository<Author,Long> {

    @Override
    <S extends Author> S save(S s);
    @Override
     Optional<Author> findById(Long aLong);

    @Override
     Iterable<Author> findAll();

    @Override
     void delete(Author author);
}
