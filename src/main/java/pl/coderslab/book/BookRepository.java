package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.category.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    metodę wyszukującą książki dla zadanego tytułu
    List<Book> findByTitle (String title);

//    metodę wyszukującą książki dla zadanej kategorii
    List<Book> findByCategory (Category category);

//    metodę wyszukującą książki dla zadanego id kategorii
    List<Book> findByCategoryId (Long id);

    // lista ksiazek dla danego autora

//    Spring will generate a query like:
//    SELECT b FROM Book b JOIN b.authors a WHERE a.id = :authorId
    List<Book> findByAuthors_Id (Long authorId);

    List<Book> findByPublisher_Name (String publisherName);

//    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN ?1 AND ?2")
//    List<Book> findByRatingBetween (int min, int max);

//    @Query("SELECT b FROM Book b WHERE b.publisher=?1")
//    List<Book> findByPublisher (Publisher publisher);

//    @Query("SELECT b FROM Book b WHERE b.category.id = :categoryId ORDER BY b.title ASC")
//    Book findFirstBookByCategoryIdOrderByTitleAsc();

}
