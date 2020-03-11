package hw.lesson.microgram51.repository;


import hw.lesson.microgram51.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepo extends CrudRepository<Song, String> {
    Song findAllById(String id);
}