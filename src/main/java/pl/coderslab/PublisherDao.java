package pl.coderslab;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PublisherDao {

    @PersistenceContext
    private EntityManager em;

    public void add(Publisher publisher) {
        em.persist(publisher);
    }

    public void update(Publisher publisher) {
        em.merge(publisher);
    }

    public Publisher get(Long id) {
        return em.find(Publisher.class, id);
    }

    public void delete(Publisher publisher) {
        em.remove(publisher);
    }
}
