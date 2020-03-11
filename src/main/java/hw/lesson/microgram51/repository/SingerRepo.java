package hw.lesson.microgram51.repository;


import hw.lesson.microgram51.model.Singer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepo extends CrudRepository<Singer, String> {
    Singer findAllById(String id);


}
