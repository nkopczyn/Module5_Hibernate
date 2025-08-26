package pl.coderslab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);

//    @Query("SELECT a FROM Author a WHERE a.email LIKE CONCAT(?1, '%')")
//    List<Author> findByEmailStartingWith(String prefix);

//    @Query("SELECT a FROM Author a WHERE a.pesel LIKE CONCAT(?1, '%')")
//    List<Author> findAuthorsByPeselPrefix(String prefix);

}
