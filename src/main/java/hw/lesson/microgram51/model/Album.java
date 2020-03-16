package hw.lesson.microgram51.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document(collection = "albums")
@Data
@CompoundIndex(def = "{'title': 1, 'produceDate': 1}")
public class Album {
    @Id
    private String id;
    private String title;
    private LocalDate produceDate;
    @DBRef
    private List<Song> songs = new ArrayList<>();
    private List<Singer> singers = new ArrayList<>();
}
