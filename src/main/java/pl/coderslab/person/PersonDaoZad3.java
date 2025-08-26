package pl.coderslab.person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PersonDaoZad3 {

    @PersistenceContext
    private EntityManager em;

    public void add(PersonZad3 person) {
        em.persist(person);
    }

    public void update(PersonZad3 person) {
        em.merge(person);
    }

    public PersonZad3 get(Long id) {
        return em.find(PersonZad3.class, id);
    }

    public void delete(PersonZad3 person) {
        em.remove(person);
    }


}
