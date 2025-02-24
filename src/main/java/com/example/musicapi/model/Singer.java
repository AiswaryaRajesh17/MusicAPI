package com.example.musicapi.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "singer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

