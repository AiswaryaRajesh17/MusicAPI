package com.example.musicapi.repository;

import com.example.musicapi.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;



   Track track = new Track();

    TrackRepositoryTest(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }





    @Test
    void findByLanguageName() {
        List<Track> tracks = trackRepository.findByLanguage_Name("English");
        assertFalse(tracks.isEmpty());
        assertEquals(1, tracks.size());
        assertEquals("English", tracks.get(0).getLanguage().getName());
    }

    @Test
    void findBySingerName() {
        List<Track> tracks = trackRepository.findBySinger_Name("Arijit Singh");
        assertFalse(tracks.isEmpty());
        assertEquals("Arijit Singh", tracks.get(0).getSinger().getName());
    }

    @Test
    void findByProducerName() {
        List<Track> tracks = trackRepository.findByProducer_Name("A. R. Rahman");
        assertFalse(tracks.isEmpty());
        assertEquals("A. R. Rahman", tracks.get(0).getProducer().getName());
    }

    @Test
    void findByGenreName() {
        List<Track> tracks = trackRepository.findByGenre_Name(("Pop"));
        assertFalse(tracks.isEmpty());
        assertEquals("Pop", tracks.get(0).getGenre().getName());
    }

    @Test
    void findByYearOfRelease() {
        List<Track> tracks = trackRepository.findByYearOfRelease_Year(2023);
        assertFalse(tracks.isEmpty());
        assertEquals(2023, tracks.get(0).getYearOfRelease().getYear());
    }

    @Test
    void findByMovieAlbumName() {
        List<Track> tracks = trackRepository.findByMovieAlbum_Name("Kabir Singh");
        assertFalse(tracks.isEmpty());
        assertEquals("Kabir Singh", tracks.get(0).getMovieAlbum().getName());
    }

    @Test
    void findByLyricsName() {
        List<Track> tracks = trackRepository.findByLyrics_Name("Agar Tum Saath Ho");
        assertFalse(tracks.isEmpty());
        assertEquals("Agar Tum Saath Ho", tracks.get(0).getLyrics().getName());
    }

    @Test
    void findByMusicDirectorName() {
        List<Track> tracks = trackRepository.findByMusicDirector_Name("Pritam");
        assertFalse(tracks.isEmpty());
        assertEquals("Pritam", tracks.get(0).getMusicDirector().getName());
    }
}