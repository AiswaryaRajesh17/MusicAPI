package com.example.musicapi.repository;


import com.example.musicapi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByLanguage_Name(String name);
    List<Track> findBySinger_Name(String name);
    List<Track> findByProducer_Name(String name);
    List<Track> findByGenre_Name(String name);
    @Query("SELECT t FROM Track t WHERE t.yearOfRelease = :year")
    List<Track> findByYearOfRelease_Year(@Param("year")Integer year);
    List<Track> findByMovieAlbum_Name(String name);
    List<Track> findByLyrics_Name(String name);
    List<Track> findByMusicDirector_Name(String name);



}

