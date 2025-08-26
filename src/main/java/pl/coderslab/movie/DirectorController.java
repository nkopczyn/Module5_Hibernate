package pl.coderslab.movie;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/director")
public class DirectorController {
    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @RequestMapping
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @RequestMapping("/add")
    public String addDirector() {
        Director director = new Director();
        director.setLastName("anderson");
        director.setFirstName("wes");
        directorRepository.save(director);
        return "Director added";
    }

    @GetMapping("/delete/{id}")
    public String deleteDirector(@PathVariable Long id) {
        directorRepository.deleteById(id);
        return "Director deleted";
    }


}
