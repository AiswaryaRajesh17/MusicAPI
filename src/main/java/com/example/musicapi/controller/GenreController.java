package com.example.musicapi.controller;

import com.example.musicapi.model.Genre;
import com.example.musicapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public Genre addGenre(@RequestBody Genre genre) {
        return genreService.addGenre(genre);
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public Optional<Genre> getGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }
}

