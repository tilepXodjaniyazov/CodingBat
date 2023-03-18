package com.example.codingbat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStarCountDto {
    private Integer userId;
    private Integer categoryId;
    private Integer starCount;
}
