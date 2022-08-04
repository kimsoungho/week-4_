package com.example.week4.Entity;

import com.example.week4.Dto.UpdateDto;
import com.example.week4.Dto.WriteDto;
import com.example.week4.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Post(WriteDto writeDto, UserDetailsImpl userDetails) {
        this.title = writeDto.getTitle();
        this.username = userDetails.getUsername();
        this.contents = writeDto.getContents();
    }

    public void Update(UpdateDto requestDto){
        this.title=requestDto.getTitle();
        this.contents=requestDto.getContents();
        this.setModifiedAt(requestDto.getModifiedAt());
    }

    public void update(UpdateDto updateDto) {
    }
}
