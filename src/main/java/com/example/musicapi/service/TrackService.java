package com.example.musicapi.service;

import com.example.musicapi.model.*;
import com.example.musicapi.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TrackService {


  private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    public Track updateTrack(Long id, Track updatedTrack) {
        return trackRepository.findById(id).map(track -> {
            track.setName(updatedTrack.getName());
            track.setSinger(updatedTrack.getSinger());
            track.setGenre(updatedTrack.getGenre());
            track.setYearOfRelease(updatedTrack.getYearOfRelease());
            track.setProducer(updatedTrack.getProducer());
            track.setMusicDirector(updatedTrack.getMusicDirector());
            track.setLyrics(updatedTrack.getLyrics());
            track.setMovieAlbum(updatedTrack.getMovieAlbum());
            return trackRepository.save(track);
        }).orElseThrow(() -> new RuntimeException("Track not found"));
    }

    public void deleteTrack(Long id) {
        trackRepository.deleteById(id);
    }



    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Optional<Track> getTrackById(Long id) {
        return trackRepository.findById(id);
    }


    public List<Track> getTracksByLanguage(String name) {
        return trackRepository.findByLanguage_Name(name);
    }

    public List<Track> getTracksBySinger(String name) {
        return trackRepository.findBySinger_Name(name);
    }


    public List<Track> getTracksByGenre(String name) {
        return trackRepository.findByGenre_Name(name);
    }


    public List<Track> getTracksByYear(Integer year) {

        return trackRepository.findByYearOfRelease_Year(year);
    }
    public List<Track> getTracksByMusicDirector(String name) {
        return trackRepository.findByMusicDirector_Name(name);
    }
    public List<Track> getTracksByProducer(String name) {
        return trackRepository.findByProducer_Name(name);
    }

    public List<Track> getTracksByMovieAlbum(String name) {
        return trackRepository.findByMovieAlbum_Name(name);
    }
    public List<Track> getTracksByLyrics(String name) {
        return trackRepository.findByLyrics_Name(name);
    }

}

