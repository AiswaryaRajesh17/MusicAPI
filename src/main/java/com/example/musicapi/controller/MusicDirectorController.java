package com.example.musicapi.controller;

import com.example.musicapi.model.MusicDirector;
import com.example.musicapi.service.MusicDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/music-directors")
public class MusicDirectorController {

    @Autowired
    private MusicDirectorService musicDirectorService;

    @PostMapping
    public MusicDirector addMusicDirector(@RequestBody MusicDirector musicDirector) {
        return musicDirectorService.addMusicDirector(musicDirector);
    }

    @GetMapping
    public List<MusicDirector> getAllMusicDirectors() {
        return musicDirectorService.getAllMusicDirectors();
    }

    @GetMapping("/{id}")
    public Optional<MusicDirector> getMusicDirectorById(@PathVariable Long id) {
        return musicDirectorService.getMusicDirectorById(id);
    }
}

