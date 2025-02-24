package com.example.musicapi.repository;

import com.example.musicapi.model.YearOfRelease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearOfReleaseRepository extends JpaRepository<YearOfRelease, Long> {
}

