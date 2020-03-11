package hw.lesson.microgram51.util;

import hw.lesson.microgram51.model.Album;
import hw.lesson.microgram51.model.Singer;
import hw.lesson.microgram51.model.Song;
import hw.lesson.microgram51.repository.AlbumRepo;
import hw.lesson.microgram51.repository.SingerRepo;
import hw.lesson.microgram51.repository.SongRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class MusicAppData {

    @Bean
    CommandLineRunner initMusic(SingerRepo singerRepo) {
        singerRepo.deleteAll();
        return (args) -> Stream.of(singers())
                .peek(System.out::println)
                .forEach(singerRepo::save);
    }

    private Singer[] singers() {
        return new Singer[]{
                new Singer("1", "Nelly", null),
                new Singer("2", "Merry", null)};
    }

    @Bean
    CommandLineRunner initAlbum(AlbumRepo albumRepo) {
        albumRepo.deleteAll();
        return (args) -> Stream.of(albums())
                .peek(System.out::println)
                .forEach(albumRepo::save);
    }

    private Album[] albums() {

        return new Album[]{
                new Album("1", "Dream", null, null, null),
                new Album("2", "Nice", null, null, null)};
    }

    @Bean
    CommandLineRunner initSong(SongRepo songRepo) {
        songRepo.deleteAll();
        return (args) -> Stream.of(songs())
                .peek(System.out::println)
                .forEach(songRepo::save);
    }

    private Song[] songs() {
        return new Song[]{
                new Song("1", "Just a dream"),
                new Song("2", "Good day"),
                new Song("3", "Just a little"),
                new Song("4", "Buttons"),
                new Song("5", "Girls Like you"),
                new Song("6", "Hush hush"),
                new Song("7", "Dangerous"),
                new Song("8", "Perfect")};
    }
}


