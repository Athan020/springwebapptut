package athandile.springFrameowrk.springwebapp.bootstrap;

import athandile.springFrameowrk.springwebapp.model.Author;
import athandile.springFrameowrk.springwebapp.model.Book;
import athandile.springFrameowrk.springwebapp.repositories.AuthorRepository;
import athandile.springFrameowrk.springwebapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Author athandile =  new Author("Athandile","Tembile");
        Book dreamer = new Book("Dreamer","2345","Deez. inc");
        athandile.getBooks().add(dreamer);
        dreamer.getAuthors().add(athandile);

        authorRepository.save(athandile);
        bookRepository.save(dreamer);

        Author zahirah =  new Author("Zahirah","Ismail");
        Book itsme = new Book("It's me","2335","8008. inc");
        zahirah.getBooks().add(itsme);
        itsme.getAuthors().add(zahirah);

        authorRepository.save(zahirah);
        bookRepository.save(itsme);
    }
}


