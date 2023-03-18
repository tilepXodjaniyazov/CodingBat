package com.example.codingbat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCaseDto {
    private Integer taskId;
    private String caseText;
}
