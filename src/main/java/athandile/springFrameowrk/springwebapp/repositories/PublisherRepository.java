package athandile.springFrameowrk.springwebapp.repositories;

import athandile.springFrameowrk.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher,Long> { }
