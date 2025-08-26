package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    metodę wyszukującą książki dla zadanego tytułu
    List<Book> findByTitle (String title);

//    metodę wyszukującą książki dla zadanej kategorii
    List<Book> findByCategory (Category category);

//    metodę wyszukującą książki dla zadanego id kategorii
    List<Book> findByCategoryId (Long id);
}
