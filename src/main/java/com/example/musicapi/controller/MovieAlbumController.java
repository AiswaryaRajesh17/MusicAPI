package com.example.musicapi.controller;

import com.example.musicapi.model.MovieAlbum;
import com.example.musicapi.service.MovieAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies-albums")
public class MovieAlbumController {

    @Autowired
    private MovieAlbumService movieAlbumService;

    @PostMapping
    public MovieAlbum addMovieAlbum(@RequestBody MovieAlbum movieAlbum) {
        return movieAlbumService.addMovieAlbum(movieAlbum);
    }

    @GetMapping
    public List<MovieAlbum> getAllMovieAlbums() {
        return movieAlbumService.getAllMovieAlbums();
    }

    @GetMapping("/{id}")
    public Optional<MovieAlbum> getMovieAlbumById(@PathVariable Long id) {
        return movieAlbumService.getMovieAlbumById(id);
    }
}

