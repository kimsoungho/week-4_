package com.example.week4.Service;

import com.example.week4.Dto.DetailDto;
import com.example.week4.Repository.PostRepository;
import com.example.week4.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DetailSevice {

    private final PostRepository postRepository;
    private final ReplyRepository repository;



    @Transactional
    public DetailDto detailDto(Long id) {
        DetailDto detailDto = new DetailDto(postRepository.getReferenceById(id),repository.findByPostid(id));

        return detailDto;
    }

}
