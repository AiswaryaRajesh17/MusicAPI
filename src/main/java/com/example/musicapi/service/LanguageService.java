package com.example.musicapi.service;

import com.example.musicapi.model.Language;
import com.example.musicapi.repository.LanguageRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language addLanguage(Language language) {
        return languageRepository.save(language);
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Optional<Language> getLanguageById(Long id) {
        return languageRepository.findById(id);
    }
}

