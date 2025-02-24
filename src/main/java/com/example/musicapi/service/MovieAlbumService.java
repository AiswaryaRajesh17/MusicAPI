package com.example.musicapi.service;

import com.example.musicapi.model.MovieAlbum;
import com.example.musicapi.repository.MovieAlbumRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieAlbumService {
    private final MovieAlbumRepository movieAlbumRepository;

    public MovieAlbumService(MovieAlbumRepository movieAlbumRepository) {
        this.movieAlbumRepository = movieAlbumRepository;
    }

    public MovieAlbum addMovieAlbum(MovieAlbum movieAlbum) {
        return movieAlbumRepository.save(movieAlbum);
    }

    public List<MovieAlbum> getAllMovieAlbums() {
        return movieAlbumRepository.findAll();
    }

    public Optional<MovieAlbum> getMovieAlbumById(Long id) {
        return movieAlbumRepository.findById(id);
    }
}

