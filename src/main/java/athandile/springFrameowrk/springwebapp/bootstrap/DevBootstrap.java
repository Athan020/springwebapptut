package athandile.springFrameowrk.springwebapp.bootstrap;

import athandile.springFrameowrk.springwebapp.model.Author;
import athandile.springFrameowrk.springwebapp.model.Book;
import athandile.springFrameowrk.springwebapp.model.Publisher;
import athandile.springFrameowrk.springwebapp.repositories.AuthorRepository;
import athandile.springFrameowrk.springwebapp.repositories.BookRepository;
import athandile.springFrameowrk.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository= publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher pub1 = new Publisher();
        pub1.setName("Deez. inc");

        publisherRepository.save(pub1);

        Author athandile =  new Author("Athandile","Tembile");
        Book dreamer = new Book("Dreamer","2345",pub1);


        athandile.getBooks().add(dreamer);
        dreamer.getAuthors().add(athandile);

        authorRepository.save(athandile);
        bookRepository.save(dreamer);

        Publisher pub2 = new Publisher();
        pub2.setName("8008. inc");
        publisherRepository.save(pub2);
        Author zahirah =  new Author("Zahirah","Ismail");
        Book itsme = new Book("It's me","2335",pub2);
        zahirah.getBooks().add(itsme);
        itsme.getAuthors().add(zahirah);

        authorRepository.save(zahirah);
        bookRepository.save(itsme);
    }
}


