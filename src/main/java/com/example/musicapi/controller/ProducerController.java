package com.example.musicapi.controller;

import com.example.musicapi.model.Producer;
import com.example.musicapi.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producers")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @PostMapping
    public Producer addProducer(@RequestBody Producer producer) {
        return producerService.addProducer(producer);
    }

    @GetMapping
    public List<Producer> getAllProducers() {
        return producerService.getAllProducers();
    }

    @GetMapping("/{id}")
    public Optional<Producer> getProducerById(@PathVariable Long id) {
        return producerService.getProducerById(id);
    }
}

