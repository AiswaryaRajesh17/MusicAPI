package com.example.musicapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "year_of_release")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YearOfRelease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private YearOfRelease year;
}

