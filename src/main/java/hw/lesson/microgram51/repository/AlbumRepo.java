package hw.lesson.microgram51.repository;


import hw.lesson.microgram51.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepo extends CrudRepository<Album, String> {

}
