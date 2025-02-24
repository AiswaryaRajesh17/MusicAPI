package com.example.musicapi.service;

import com.example.musicapi.model.Genre;
import com.example.musicapi.repository.GenreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }
}

