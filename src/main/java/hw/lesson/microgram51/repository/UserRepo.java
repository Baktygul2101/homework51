package hw.lesson.microgram51.repository;



import hw.lesson.microgram51.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {

}
