package com.example.week4.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class ListDto {
    Long id;
    String title;
    String username;
    LocalDateTime createAt;
    LocalDateTime modifiedAt;
}
