package pl.coderslab.song;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validatesong")
    public String validateSong() {
        Song song = new Song();
        song.setTitle("Some Title");
        song.setRating(23);

        Set<ConstraintViolation<Song>> constraintViolations = validator.validate(song);

        if (constraintViolations.isEmpty()) {
            return "ok";
        } else {
            String collect = constraintViolations.stream()
                    .map(cv -> cv.getPropertyPath().toString()
                            .concat("  : ")
                            .concat(cv.getMessage())
                            .concat(" "))
                    .collect(Collectors.joining());

            return "fail " + collect;
        }

    }
}
