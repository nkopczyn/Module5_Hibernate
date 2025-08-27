package pl.coderslab.album;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Genre> genres;
    private double rating;
}
