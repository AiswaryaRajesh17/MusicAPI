package com.example.musicapi.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "track")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "singer_id", nullable = false)
    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "lyrics_id")
    private Lyrics lyrics;

    @ManyToOne
    @JoinColumn(name = "music_director_id")
    private MusicDirector musicDirector;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "year_of_release_id")
    private YearOfRelease yearOfRelease;

    @ManyToOne
    @JoinColumn(name = "movie_album_id")
    private MovieAlbum movieAlbum;

}
