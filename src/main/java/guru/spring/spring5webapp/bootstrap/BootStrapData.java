package guru.spring.spring5webapp.bootstrap;

import guru.spring.spring5webapp.domain.Address;
import guru.spring.spring5webapp.domain.Author;
import guru.spring.spring5webapp.domain.Book;
import guru.spring.spring5webapp.domain.Publisher;
import guru.spring.spring5webapp.repositories.AuthorRepository;
import guru.spring.spring5webapp.repositories.BookRepository;
import guru.spring.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author thompson =new Author("Thompson", "Guru");
        Book ddd =new Book("Spring5", "122333444");
        thompson.getBooks().add(ddd);
        ddd.getAuthors().add(thompson);
        authorRepository.save(thompson);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Yusuf");
        Book shakes = new Book("Shakes", "Spare");
        rod.getBooks().add(shakes);
        shakes.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(shakes);


        Publisher pub =new Publisher("Alade", "Lagos");
        publisherRepository.save(pub);


        System.out.println("Starting bootstrap");
        System.out.println("Number of books: "+ bookRepository.count());

    }




}
