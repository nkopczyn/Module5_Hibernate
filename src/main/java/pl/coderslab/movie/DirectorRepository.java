package pl.coderslab.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
