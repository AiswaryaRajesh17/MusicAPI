package com.example.musicapi.service;

import com.example.musicapi.model.Producer;
import com.example.musicapi.repository.ProducerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public Producer addProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    public Optional<Producer> getProducerById(Long id) {
        return producerRepository.findById(id);
    }
}

