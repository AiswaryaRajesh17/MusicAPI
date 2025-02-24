package com.example.musicapi.controller;

import com.example.musicapi.model.Language;
import com.example.musicapi.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public Language addLanguage(@RequestBody Language language) {
        return languageService.addLanguage(language);
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public Optional<Language> getLanguageById(@PathVariable Long id) {
        return languageService.getLanguageById(id);
    }
}

