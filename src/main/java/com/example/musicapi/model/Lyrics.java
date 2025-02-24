package com.example.musicapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lyrics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lyrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

