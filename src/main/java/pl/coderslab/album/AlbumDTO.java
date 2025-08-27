package pl.coderslab.album;

import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {

    private Long id;
    private String title;
    private int releaseYear;
    private List<Genre> genres;
    private double rating;
}
