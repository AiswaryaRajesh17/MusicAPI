package com.example.musicapi.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

