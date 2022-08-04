package com.example.week4.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDto {

    String title;
    String contents;
    @LastModifiedDate
    //마지막 수정 날자
    LocalDateTime modifiedAt;
    //시간
}
