package hw.lesson.microgram51.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document(collection = "comments")
@Data
public class Comment {
    @Id
    private String idComment;
    private String commentText;
    private LocalDateTime timeCom;
    private User author;
    private List<Comment> childComments=new ArrayList<>();
}