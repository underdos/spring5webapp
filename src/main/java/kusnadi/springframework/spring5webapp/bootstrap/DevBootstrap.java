package kusnadi.springframework.spring5webapp.bootstrap;

import kusnadi.springframework.spring5webapp.model.Author;
import kusnadi.springframework.spring5webapp.model.Book;
import kusnadi.springframework.spring5webapp.model.Publisher;
import kusnadi.springframework.spring5webapp.repositories.AuthorRepository;
import kusnadi.springframework.spring5webapp.repositories.BookRepository;
import kusnadi.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("Bogor Publisher");
        publisher.setAddress("Jl Raya Bogor KM 57");

        publisherRepository.save(publisher);


        Author kusnadi = new Author("Kusnadi", "Encus");
        Book dpij = new Book("Design Pattern in Java", "1234", publisher);
        kusnadi.getBooks().add(dpij);
        dpij.getAuthors().add(kusnadi);

        authorRepository.save(kusnadi);
        bookRepository.save(dpij);

        Author subur = new Author("Subur", "Denoy");
        Book eb = new Book("Economic Business", "4321", publisher);
        subur.getBooks().add(eb);
        eb.getAuthors().add(subur);

        authorRepository.save(subur);
        bookRepository.save(eb);
    }
}
