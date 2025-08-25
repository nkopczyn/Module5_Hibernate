package pl.coderslab;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/books/add")
    public String addBook() {
        Book book = new Book();
        book.setTitle("Book Title");
        book.setAuthor("Author");
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




}
