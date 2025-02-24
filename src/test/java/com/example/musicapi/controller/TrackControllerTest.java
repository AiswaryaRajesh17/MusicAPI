package com.example.musicapi.controller;

import com.example.musicapi.model.Track;
import com.example.musicapi.service.TrackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


class TrackControllerTest {

    @Mock
    private TrackService trackService;

    @InjectMocks
    private TrackController trackController;

    private Track track;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        track = Track.builder()
                .id(1L)
                .name("Test Track")
                .build();
    }
    @Test
    void addTrack() {
        when(trackService.addTrack(any(Track.class))).thenReturn(track);

        ResponseEntity<Track> response = trackController.addTrack(track);

        assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertEquals("Test Track", Objects.requireNonNull(response.getBody()).getName());

        verify(trackService, times(1)).addTrack(any(Track.class));
    }



    @Test
    void updateTrack() {
        Long trackId = 1L;
        Track updatedTrack = Track.builder().id(trackId).name("Updated Track").build();

        when(trackService.updateTrack(eq(trackId), any(Track.class))).thenReturn(updatedTrack);

        ResponseEntity<Track> response = trackController.updateTrack(trackId, updatedTrack);

        assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Assertions.assertEquals("Updated Track", response.getBody().getName());

        verify(trackService, times(1)).updateTrack(eq(trackId), any(Track.class));
    }

    @Test
    void deleteTrack() {
        Long trackId = 1L;

        ResponseEntity<Void> response = trackController.deleteTrack(trackId);

        Assertions.assertEquals(204, response.getStatusCode().value());
        verify(trackService, times(1)).deleteTrack(trackId);
    }

    @Test
    void getAllTracks() {
        List<Track> trackList = Arrays.asList(
                track, Track.builder().id(2L).name("Another Track").build()
        );

        when(trackService.getAllTracks()).thenReturn(trackList);

        List<Track> response = trackController.getAllTracks();

        assertNotNull(response);
        Assertions.assertEquals(2, response.size());

        verify(trackService, times(1)).getAllTracks();
    }


    @Test
    void getTrackById() {
        Long trackId = 1L;
        Track track = Track.builder().id(trackId).name("Test Track").build();

        when(trackService.getTrackById(trackId)).thenReturn(Optional.of(track));

        Optional<Track> response = trackController.getTrackById(trackId);

        Assertions.assertTrue(response.isPresent());
        Assertions.assertEquals(trackId, response.get().getId());
        Assertions.assertEquals("Test Track", response.get().getName());

        verify(trackService, times(1)).getTrackById(trackId);
    }

//    @Test
//    void filterTracks() {
//    }
void getTracksByLanguage() {
    when(trackService.getTracksByLanguage("English")).thenReturn(List.of(track));

    ResponseEntity<List<Track>> response = trackController.getTracksByLanguage("English");

    Assertions.assertEquals(200, response.getStatusCode().value());
    Assertions.assertEquals(1, Objects.requireNonNull(response.getBody()).size());
    Assertions.assertEquals("English", response.getBody().getFirst().getName());
    verify(trackService, times(1)).getTracksByLanguage("English");
}
    @Test
    void getTracksBySinger() {
        when(trackService.getTracksBySinger("John Doe")).thenReturn(List.of(track));

        ResponseEntity<List<Track>> response = trackController.getTracksBySinger("John Doe");

        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getName());
        verify(trackService, times(1)).getTracksBySinger("John Doe");
    }
    @Test
    void getTracksByGenre() {
        when(trackService.getTracksByGenre("Pop")).thenReturn(List.of(track));

        ResponseEntity<List<Track>> response = trackController.getTracksByGenre("Pop");

        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        Assertions.assertEquals("Pop", response.getBody().getFirst().getName());
        verify(trackService, times(1)).getTracksByGenre("Pop");
    }

    @Test
    void getTracksByYear() {
        when(trackService.getTracksByYear(2022)).thenReturn(List.of(track));

        ResponseEntity<List<Track>> response = trackController.getTracksByYear(2022);

        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        Assertions.assertEquals(2022, response.getBody().getFirst().getYearOfRelease());
        verify(trackService, times(1)).getTracksByYear(2022);
    }

    @Test
    void getTracksByMusicDirector() {
        when(trackService.getTracksByMusicDirector("John Composer")).thenReturn(List.of(track));

        ResponseEntity<List<Track>> response = trackController.getTracksByMusicDirector("John Composer");

        Assertions.assertEquals(200, response.getStatusCode().value());
        verify(trackService, times(1)).getTracksByMusicDirector("John Composer");
    }

    @Test
    void getTracksByProducer() {
        when(trackService.getTracksByProducer("John Producer")).thenReturn(List.of(track));

        ResponseEntity<List<Track>> response = trackController.getTracksByProducer("John Producer");

        Assertions.assertEquals(200, response.getStatusCode().value());
        verify(trackService, times(1)).getTracksByProducer("John Producer");
    }

    @Test
    void getTracksByMovieAlbum() {
        when(trackService.getTracksByMovieAlbum("Test Album")).thenReturn(List.of(track));

        ResponseEntity<List<Track>> response = trackController.getTracksByMovieAlbum("Test Album");

        Assertions.assertEquals(200, response.getStatusCode().value());
        verify(trackService, times(1)).getTracksByMovieAlbum("Test Album");
    }

    @Test
    void getTracksByLyrics() {
        when(trackService.getTracksByLyrics("Test Lyrics")).thenReturn(List.of(track));

        ResponseEntity<List<Track>> response = trackController.getTracksByLyrics("Test Lyrics");

        Assertions.assertEquals(200, response.getStatusCode().value());
        verify(trackService, times(1)).getTracksByLyrics("Test Lyrics");
    }
}