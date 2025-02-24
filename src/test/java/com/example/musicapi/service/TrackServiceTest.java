package com.example.musicapi.service;

import com.example.musicapi.model.*;
import com.example.musicapi.repository.TrackRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;




import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import static org.mockito.ArgumentMatchers.any;


import com.example.musicapi.repository.TrackRepository;
import com.example.musicapi.service.TrackService;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.when;


@ExtendWith({MockitoExtension.class})
@MockitoSettings(strictness = Strictness.LENIENT)

class TrackServiceTest {

    @Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private TrackService trackService;

   Track track;



//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        Singer singer = new Singer();
//        singer.setId(1L);
//        singer.setName("John Doe");
//
//        Genre genre = new Genre();
//        genre.setId(1L);
//        genre.setName("John Doe");
//
//        Producer producer = new Producer();
//        producer.setId(1L);
//        producer.setName("Sony Music");
//
//        MusicDirector musicDirector = new MusicDirector();
//        musicDirector.setId(1L);
//        musicDirector.setName("Hans Zimmer");
//
//        Lyrics lyrics = new Lyrics();
//        lyrics.setId(1L);
//        lyrics.setName("Some Lyrics");
//
//        MovieAlbum movieAlbum = new MovieAlbum();
//        movieAlbum.setId(1L);
//        movieAlbum.setName("Inception");
//
//       YearOfRelease year = new YearOfRelease();
//       year.setId(1L);
//        year.setYear(2022);
//        track.setYearOfRelease(year);
//
//        track = Track.builder()
//                .id(1L)
//                .name("Test Song")
//                .singer(singer)
//                .genre(genre)
//                .yearOfRelease(year)
//                .producer(producer)
//                .musicDirector(musicDirector)
//                .lyrics(lyrics)
//                .movieAlbum(movieAlbum)
//                .build();
//    }



    @Test
    void addTrack() {

        when(trackRepository.save(any(Track.class))).thenReturn(track);

        Track savedTrack = trackService.addTrack(track);

        assertNotNull(savedTrack);
        assertEquals("Test Song", savedTrack.getName());
        verify(trackRepository, times(1)).save(any(Track.class));


    }

    @Test
    void updateTrack() {
        Long trackId = 1L;
        Track updatedTrack = Track.builder()
                .id(trackId)
                .name("Updated Track Name")
                .build();

        when(trackRepository.findById(trackId)).thenReturn(Optional.of(track));
        when(trackRepository.save(any(Track.class))).thenReturn(updatedTrack);


        Track result = trackService.updateTrack(trackId, updatedTrack);

        assertNotNull(result);
        assertEquals("Updated Track Name", result.getName());
        verify(trackRepository, times(1)).findById(trackId);
        verify(trackRepository, times(1)).save(any(Track.class));
    }

    @Test
    void deleteTrack() {
        Long trackId = 1L;


        trackService.deleteTrack(trackId);


        verify(trackRepository, times(1)).deleteById(trackId);
    }

    @Test
    void getAllTracks() {
        Track track2 = Track.builder()
                .id(2L)
                .name("Another Song")
                .build();

        List<Track> tracks = Arrays.asList(track, track2);
        when(trackRepository.findAll()).thenReturn(tracks);

        List<Track> result = trackService.getAllTracks();

        assertEquals(2, result.size());
        verify(trackRepository, times(1)).findAll();
    }


    @Test
    void getTrackById() {
        when(trackRepository.findById(1L)).thenReturn(Optional.of(track));

        Optional<Track> result = trackService.getTrackById(1L);

        Assertions.assertTrue(result.isPresent());
        assertEquals("Test Song", result.get().getName());
        verify(trackRepository, times(1)).findById(1L);

    }

    @Test
    void getTracksByLanguage() {
        when(trackRepository.findByLanguage_Name("English"))
                .thenReturn(Arrays.asList(track));

        List<Track> result = trackService.getTracksByLanguage("English");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trackRepository, times(1)).findByLanguage_Name("English");
    }

    @Test
    void getTracksBySinger() {
        when(trackRepository.findBySinger_Name("John Doe"))
                .thenReturn(Arrays.asList(track));

        List<Track> result = trackService.getTracksBySinger("John Doe");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trackRepository, times(1)).findBySinger_Name("John Doe");
    }

    @Test
    void getTracksByGenre() {
        when(trackRepository.findByGenre_Name("Pop"))
                .thenReturn(Arrays.asList(track));

        List<Track> result = trackService.getTracksByGenre("Pop");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trackRepository, times(1)).findByGenre_Name("Pop");
    }


        @Test
        void getTracksByYear() {
            when(trackRepository.findByYearOfRelease_Year(2022))
                    .thenReturn(Arrays.asList(track));

            List<Track> result = trackService.getTracksByYear(2022);

            assertNotNull(result);
            assertEquals(1, result.size());
            verify(trackRepository, times(1)).findByYearOfRelease_Year(2022);
        }



    @Test
    void getTracksByMusicDirector() {
        when(trackRepository.findByMusicDirector_Name("Hans Zimmer"))
                .thenReturn(Arrays.asList(track));

        List<Track> result = trackService.getTracksByMusicDirector("Hans Zimmer");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trackRepository, times(1)).findByMusicDirector_Name("Hans Zimmer");
    }

    @Test
    void getTracksByProducer() {
        when(trackRepository.findByProducer_Name("Sony Music"))
                .thenReturn(Arrays.asList(track));

        List<Track> result = trackService.getTracksByProducer("Sony Music");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trackRepository, times(1)).findByProducer_Name("Sony Music");
    }

    @Test
    void getTracksByMovieAlbum() {
        when(trackRepository.findByMovieAlbum_Name("Inception"))
                .thenReturn(Arrays.asList(track));

        List<Track> result = trackService.getTracksByMovieAlbum("Inception");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trackRepository, times(1)).findByMovieAlbum_Name("Inception");
    }
    @Test
    void getTracksByLyrics() {
        when(trackRepository.findByLyrics_Name("Inception"))
                .thenReturn(Arrays.asList(track));

        List<Track> result = trackService.getTracksByMovieAlbum("Inception");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trackRepository, times(1)).findByLyrics_Name("Inception");
    }

}