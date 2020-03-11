package hw.lesson.microgram51.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="users")
@Data
@CompoundIndex(def = "{'name': 1, 'email': 1}")
public class User {
     @Id public String id;
    private String name;
    private String email;
    private String password;
    public List<Post> posts = new ArrayList<>();
    private int publications = 0;
    private int subscriber = 0;
    private int subscription = 0;
    private int likes=0; //not sure for this statement here, maybe will transfer to another class


    public User(String id, String name, String email, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = posts;
    }


    public void likes() {
    }
}
