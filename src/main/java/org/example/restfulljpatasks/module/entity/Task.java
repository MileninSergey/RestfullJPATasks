package org.example.restfulljpatasks.module.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "tasks")
@Data

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate createDate;
    private LocalDateTime implementTime;
}
