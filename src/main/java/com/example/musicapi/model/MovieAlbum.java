package com.example.musicapi.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_album")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

