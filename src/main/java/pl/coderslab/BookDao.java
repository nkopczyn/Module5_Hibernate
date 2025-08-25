package pl.coderslab;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class BookDao {

    @PersistenceContext //adnotacja do wstrzykiwania EntityManager
    private EntityManager em;

    public void save(Book book) {
        em.persist(book);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public Book get(Long id) {
        return em.find(Book.class, id);
    }

    public void delete(Book book) {
        em.remove(book);
    }


}
