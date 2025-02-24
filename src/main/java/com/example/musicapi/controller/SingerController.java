package com.example.musicapi.controller;

import com.example.musicapi.model.Singer;
import com.example.musicapi.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/singers")
public class SingerController {
    @Autowired
    private SingerService singerService;



    @PostMapping
    public Singer addSinger(@RequestBody Singer singer) {
        return singerService.addSinger(singer);
    }

    @GetMapping
    public List<Singer> getAllSingers() {
        return singerService.getAllSingers();
    }

    @GetMapping("/{id}")
    public Optional<Singer> getSingerById(@PathVariable Long id) {
        return singerService.getSingerById(id);
    }
}

