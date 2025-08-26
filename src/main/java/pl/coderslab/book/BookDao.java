package pl.coderslab.book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    // JPQL
    public List findAll(){
        Query query = em.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    // wszystkie books co mają publishera
    public List findAllWithPublisher() {
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.publisher is not null");
        return query.getResultList();
    }


}
