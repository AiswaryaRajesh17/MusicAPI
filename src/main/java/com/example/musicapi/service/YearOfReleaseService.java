package com.example.musicapi.service;

import com.example.musicapi.model.YearOfRelease;
import com.example.musicapi.repository.YearOfReleaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class YearOfReleaseService {
    private final YearOfReleaseRepository yearOfReleaseRepository;

    public YearOfReleaseService(YearOfReleaseRepository yearOfReleaseRepository) {
        this.yearOfReleaseRepository = yearOfReleaseRepository;
    }

    public YearOfRelease addYear(YearOfRelease year) {
        return yearOfReleaseRepository.save(year);
    }

    public List<YearOfRelease> getAllYears() {
        return yearOfReleaseRepository.findAll();
    }

    public Optional<YearOfRelease> getYearById(Long id) {
        return yearOfReleaseRepository.findById(id);
    }
}

