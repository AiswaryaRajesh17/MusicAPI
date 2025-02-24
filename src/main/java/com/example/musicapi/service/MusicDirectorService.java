package com.example.musicapi.service;

import com.example.musicapi.model.MusicDirector;
import com.example.musicapi.repository.MusicDirectorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MusicDirectorService {
    private final MusicDirectorRepository musicDirectorRepository;

    public MusicDirectorService(MusicDirectorRepository musicDirectorRepository) {
        this.musicDirectorRepository = musicDirectorRepository;
    }

    public MusicDirector addMusicDirector(MusicDirector musicDirector) {
        return musicDirectorRepository.save(musicDirector);
    }

    public List<MusicDirector> getAllMusicDirectors() {
        return musicDirectorRepository.findAll();
    }

    public Optional<MusicDirector> getMusicDirectorById(Long id) {
        return musicDirectorRepository.findById(id);
    }
}

