package com.example.musicapi.service;

import com.example.musicapi.model.Lyrics;
import com.example.musicapi.repository.LyricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LyricsService {
    @Autowired
    private final LyricsRepository lyricsRepository;

    public LyricsService(LyricsRepository lyricsRepository) {
        this.lyricsRepository = lyricsRepository;
    }

    public Lyrics addLyrics(Lyrics lyrics) {
        return lyricsRepository.save(lyrics);
    }

    public List<Lyrics> getAllLyrics() {
        return lyricsRepository.findAll();
    }

    public Optional<Lyrics> getLyricsById(Long id) {
        return lyricsRepository.findById(id);
    }
}

