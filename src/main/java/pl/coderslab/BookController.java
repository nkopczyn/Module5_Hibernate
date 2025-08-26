package pl.coderslab;

import org.springframework.web.bind.annotation.GetMapping;
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
    // spring data - cos zamiennego z dao
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao,
                          AuthorDao authorDao, PersonDaoZad3 personDaoZad3,
                          BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.personDaoZad3 = personDaoZad3;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/books/add")
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher3");
        publisherDao.add(publisher);

        Author author1 = new Author();
        author1.setFirstName("kuba");
        author1.setLastName("kubowski");
        authorDao.add(author1);
        Author author2 = new Author();
        author2.setFirstName("ola");
        author2.setLastName("oloska");
        authorDao.add(author2);

        Category category1 = new Category();
        category1.setName("fantasy");

        // jpa repo ma wbudowaną metode save, category repo może być puste byle by było
        categoryRepository.save(category1);

        List<Author> authorsForBook1 = List.of(author1, author2);

        Book book = new Book();
        book.setTitle("Book3");
        book.setPublisher(publisher);
        book.setAuthors(authorsForBook1);
        book.setIsbn("123345");
        book.setCategory(category1);
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

    //JPQL
    @RequestMapping("/books/all")
    public String findAll() {
        List<Book> all = bookDao.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : all) {
            stringBuilder.append(book.getTitle());
        }
        return stringBuilder.toString();
    }

    @RequestMapping("/books/withpublisher")
    public String booksWithPublisher() {
        List<Book> all = bookDao.findAllWithPublisher();
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : all) {
            stringBuilder.append(book.getTitle());
        }
        return stringBuilder.toString();
    }

    // spring data
    @GetMapping("/repoallbooks")
    public String repoAllBooks() {
        return bookRepository.findAll().toString();
    }

    @GetMapping("/repobooks/title/{title}")
    public String repoBookTitle(@PathVariable("title") String title) {
        return bookRepository.findByTitle(title).toString();
    }

//    @GetMapping("/repobooks/cat/{category}")
//    public List<Book> repoFindBookByCategory(@PathVariable("category") String category) {
//
//        return bookRepository.findByCategory();
//    }
}
