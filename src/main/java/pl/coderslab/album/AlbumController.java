package pl.coderslab.album;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    private final AlbumRepository albumRepository;
    private final AlbumService albumService;

    public AlbumController(AlbumRepository albumRepository, AlbumService albumService) {
        this.albumRepository = albumRepository;
        this.albumService = albumService;
    }

    @GetMapping("/album/{id}")
    public AlbumDTO findAlbumById(@PathVariable("id") Long id) {
        Album album = albumRepository.findById(id).orElse(null);
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(album.getId());
        albumDTO.setTitle(album.getTitle());
        albumDTO.setReleaseYear(album.getReleaseYear());
        albumDTO.setGenres(album.getGenres());
        albumDTO.setRating(album.getRating());
        return albumDTO;

    }

    @GetMapping("/albumservice/all")
    public List<Album> findAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return albums;
    }

}
