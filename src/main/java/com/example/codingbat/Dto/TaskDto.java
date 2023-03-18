package com.example.codingbat.Dto;

import com.example.codingbat.Entity.Category;
import com.example.codingbat.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String name;
    private Integer categoryId;
    private String question;
    private String template;
    private String answerText;
    private String solution;
    private Integer userId;
}
