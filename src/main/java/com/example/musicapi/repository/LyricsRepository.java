package com.example.musicapi.repository;

import com.example.musicapi.model.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LyricsRepository extends JpaRepository<Lyrics, Long> {
}

