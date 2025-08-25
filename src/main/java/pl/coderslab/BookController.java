package pl.coderslab;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final PersonDaoZad3 personDaoZad3;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, PersonDaoZad3 personDaoZad3) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.personDaoZad3 = personDaoZad3;
    }

    @RequestMapping("/books/add")
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher1");
        publisherDao.add(publisher);

        Author author1 = new Author();
        author1.setFirstName("jan");
        author1.setLastName("kowalski");
        authorDao.add(author1);
        Author author2 = new Author();
        author2.setFirstName("zosia");
        author2.setLastName("nowak");
        authorDao.add(author2);

        List<Author> authorsForBook1 = List.of(author1, author2);

        Book book = new Book();
        book.setTitle("Book Title");
        book.setPublisher(publisher);
        book.setAuthors(authorsForBook1);
        book.setIsbn("123345");
        // nie można ustawiać ID ręcznie, @GeneratedValue ustawia je automatycznie
        bookDao.save(book);

        return "Book added";
    }

    @RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") long id) {
        Book foundBook = bookDao.get(id);
        foundBook.setTitle("New Title");
        bookDao.update(foundBook);

        return "Book number " + id + " updated";
    }

    @RequestMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        Book foundBook = bookDao.get(id);
        bookDao.delete(foundBook);

        return "Book number " + id + " deleted";
    }

    @RequestMapping("/books/show/{id}")
    public String showBook(@PathVariable("id") long id) {
        Book foundBook = bookDao.get(id);

        return "Book number " + foundBook.getId() + " : " + foundBook.getTitle();
    }

    // ZADANIE 3
    @RequestMapping("/person/add")
    public String addPerson() {
        PersonZad3 person = new PersonZad3();
        person.setLogin("admin");
        personDaoZad3.add(person);

        return "Person added";
    }




}
