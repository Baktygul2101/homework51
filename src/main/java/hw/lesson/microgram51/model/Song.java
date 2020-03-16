package hw.lesson.microgram51.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Song {
    @Id
    private String id;
    @Indexed (name="composition")
    private String composition;

    public Song(String id, String composition, Singer singer) {
        this.id = id;
        this.composition = composition;
        this.singer = singer;
    }

    private Singer singer;


    public Song(String id, String composition) {
    }
}
