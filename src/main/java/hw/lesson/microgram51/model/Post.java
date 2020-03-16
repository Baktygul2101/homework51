package hw.lesson.microgram51.model;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "posts")
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public  class Post {

    public int id;
    private String imageLink;
    private LocalDateTime timePub;
    private String description;
    private List<Comment> comments = new ArrayList<>();

}