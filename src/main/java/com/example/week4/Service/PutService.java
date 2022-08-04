package com.example.week4.Service;

import com.example.week4.Dto.UpdateDto;
import com.example.week4.Entity.Post;
import com.example.week4.Repository.PostRepository;
import com.example.week4.security.UserDetailsImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PutService {

    private final PostRepository postRepository;


    public PutService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public String Update(Long id, UpdateDto updateDto, UserDetailsImpl userDetails) {
        Post post1 = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (!userDetails.getUsername().equals(post1.getUsername())) {
            return "본인 게시글만 수정이 가능합니다!..";
        }
        post1.update(updateDto);
        return "ID: [" + post1.getId() + "]의 업데이트 완료!";
    }
}