package hw.lesson.microgram51.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "likes")
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class LikeModel{
@Id
        private int idLike;
        private User whoLikes;
        private Post whatLikes;
        private LocalDateTime timeLike;

}