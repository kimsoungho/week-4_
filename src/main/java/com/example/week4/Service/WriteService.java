package com.example.week4.Service;

import com.example.week4.Dto.WriteDto;
import com.example.week4.Entity.Post;
import com.example.week4.Repository.PostRepository;
import com.example.week4.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor

public class WriteService {
    private final PostRepository postRepository;

    @Transactional
    public String Write(WriteDto writeDto, UserDetailsImpl userDetails) {
        Post post = new Post(writeDto,userDetails);
        postRepository.save(post);
        return post.getId()+"저장";
    }
}

