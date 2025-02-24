package com.example.musicapi.service;

import com.example.musicapi.model.Singer;
import com.example.musicapi.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SingerService {
    @Autowired
    private  SingerRepository singerRepository;



    public Singer addSinger(Singer singer) {
        return singerRepository.save(singer);
    }

    public List<Singer> getAllSingers() {
        return singerRepository.findAll();
    }

    public Optional<Singer> getSingerById(Long id) {
        return singerRepository.findById(id);
    }
}

