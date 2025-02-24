package com.example.musicapi.controller;

import com.example.musicapi.model.YearOfRelease;
import com.example.musicapi.service.YearOfReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/years")
public class YearOfReleaseController {

    @Autowired
    private YearOfReleaseService yearOfReleaseService;

    @PostMapping
    public YearOfRelease addYear(@RequestBody YearOfRelease year) {
        return yearOfReleaseService.addYear(year);
    }

    @GetMapping
    public List<YearOfRelease> getAllYears() {
        return yearOfReleaseService.getAllYears();
    }

    @GetMapping("/{id}")
    public Optional<YearOfRelease> getYearById(@PathVariable Long id) {
        return yearOfReleaseService.getYearById(id);
    }
}

