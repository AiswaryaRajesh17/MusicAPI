package com.example.musicapi.controller;

import com.example.musicapi.model.Lyrics;
import com.example.musicapi.service.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lyrics")
public class LyricsController {

    @Autowired
    private LyricsService lyricsService;

    @PostMapping
    public Lyrics addLyrics(@RequestBody Lyrics lyrics) {
        return lyricsService.addLyrics(lyrics);
    }

    @GetMapping
    public List<Lyrics> getAllLyrics() {
        return lyricsService.getAllLyrics();
    }

    @GetMapping("/{id}")
    public Optional<Lyrics> getLyricsById(@PathVariable Long id) {
        return lyricsService.getLyricsById(id);
    }
}

