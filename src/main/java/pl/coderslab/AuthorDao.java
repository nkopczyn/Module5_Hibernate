package pl.coderslab;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class AuthorDao {

    @PersistenceContext
    private EntityManager em;

    public void add(Author author) {
        em.persist(author);
    }

    public void update(Author author) {
        em.merge(author);
    }

    public Author get(Long id) {
        return em.find(Author.class, id);
    }

    public void delete(Author author) {
        em.remove(author);
    }


}
