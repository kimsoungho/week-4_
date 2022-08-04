package com.example.week4.Service;

import com.example.week4.Dto.ListDto;
import com.example.week4.Entity.Post;
import com.example.week4.Repository.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    private final PostRepository postRepository;

    public ListService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<ListDto> ListGet() {
        List<Post> tours = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

        List<ListDto> GetDto = new ArrayList<>();
        for (int i = 0; i < postRepository.count(); i++) {
            Post postinfo = tours.get(i);
            ListDto postGetDto = new ListDto(postinfo.getId(),postinfo.getTitle(), postinfo.getUsername(), postinfo.getCreatedAt(),postinfo.getModifiedAt());
            GetDto.add(postGetDto);
        }
        return GetDto;
    }

}