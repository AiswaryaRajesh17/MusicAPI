package com.example.musicapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "music_director")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusicDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

