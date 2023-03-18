package com.example.codingbat.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private Category category;
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private String template;
    @Column(nullable = false)
    private String answerText;
    @Column(nullable = false)
    private String solution;
    @ManyToOne
    private User user;
}
