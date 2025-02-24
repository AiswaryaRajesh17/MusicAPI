package com.example.musicapi.controller;

import com.example.musicapi.model.Track;
import com.example.musicapi.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @PostMapping("/tracks")
    public ResponseEntity<Track> addTrack(@RequestBody Track track) {
        Track savedTrack = trackService.addTrack(track);
        return ResponseEntity.ok(savedTrack);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody Track track) {
        Track updatedTrack = trackService.updateTrack(id, track);
        return ResponseEntity.ok(updatedTrack);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }

    @GetMapping("/{id}")
    public Optional<Track> getTrackById(@PathVariable Long id) {
        return trackService.getTrackById(id);
    }


    @GetMapping("/language/{language}")
    public ResponseEntity<List<Track>> getTracksByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(trackService.getTracksByLanguage(language));
    }
    @GetMapping("/singer/{singer}")
    public ResponseEntity<List<Track>> getTracksBySinger(@PathVariable String singer) {
        return ResponseEntity.ok(trackService.getTracksBySinger(singer));
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Track>> getTracksByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(trackService.getTracksByGenre(genre));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Track>> getTracksByYear(@PathVariable Integer year) {
        return ResponseEntity.ok(trackService.getTracksByYear(year));
    }

    @GetMapping("/music-director/{musicDirector}")
    public ResponseEntity<List<Track>> getTracksByMusicDirector(@PathVariable String musicDirector) {
        return ResponseEntity.ok(trackService.getTracksByMusicDirector(musicDirector));
    }

    @GetMapping("/producer/{producer}")
    public ResponseEntity<List<Track>> getTracksByProducer(@PathVariable String producer) {
        return ResponseEntity.ok(trackService.getTracksByProducer(producer));
    }

    @GetMapping("/movie-album/{movieAlbum}")
    public ResponseEntity<List<Track>> getTracksByMovieAlbum(@PathVariable String movieAlbum) {
        return ResponseEntity.ok(trackService.getTracksByMovieAlbum(movieAlbum));
    }

    @GetMapping("/lyrics/{lyrics}")
    public ResponseEntity<List<Track>> getTracksByLyrics(@PathVariable String lyrics) {
        return ResponseEntity.ok(trackService.getTracksByLyrics(lyrics));
    }
//    @GetMapping("/filter")
//    public List<Track> filterTracks(
//            @RequestParam(required = false) String language,
//            @RequestParam(required = false) String singer,
//            @RequestParam(required = false) String genre,
//            @RequestParam(required = false) Integer year,
//            @RequestParam(required = false) String movieAlbum,
//             @RequestParam(required = false) String musicDirector,
//         @RequestParam(required = false) String producer),
//             @RequestParam(required = false) String lyrics)
//    {
//
//        if (language != null) return trackService.getTracksByLanguage(language);
//        if (singer != null) return trackService.getTracksBySinger(singer);
//        if (genre != null) return trackService.getTracksByGenre(genre);
//        if (year != null) return trackService.getTracksByYear(year);
//        if ( movieAlbum != null) return trackService.getTracksByMovieAlbum(movieAlbum);
//        if ( producer != null) return trackService.getTracksByProducer(producer);
//        if (musicDirector != null) return trackService.getTracksByMusicDirector(musicDirector);
//        if (lyrics != null) return trackService.getTracksByLyrics(lyrics);
//
//        return trackService.getAllTracks();
//    }
}

