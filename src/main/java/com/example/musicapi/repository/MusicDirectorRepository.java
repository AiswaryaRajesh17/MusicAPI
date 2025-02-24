package com.example.musicapi.repository;

import com.example.musicapi.model.MusicDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicDirectorRepository extends JpaRepository<MusicDirector, Long> {
}

