package com.example.musicapi.repository;

import com.example.musicapi.model.MovieAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieAlbumRepository extends JpaRepository<MovieAlbum, Long> {
}

