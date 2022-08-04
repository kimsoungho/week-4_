package com.example.week4.Service;

import com.example.week4.Dto.UpdateDto;
import com.example.week4.Entity.Post;
import com.example.week4.Entity.Reply;
import com.example.week4.Repository.PostRepository;
import com.example.week4.Repository.ReplyRepository;
import com.example.week4.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DeleteService {

    private final PostRepository postRepository;

    private final ReplyRepository replyRepository;

    @Transactional
    public String DeletePost(Long id, UserDetailsImpl userDetails){
        Post post1 = postRepository.getReferenceById(id);
        if (!userDetails.getUsername().equals(post1.getUsername())){
            return "본인 게시글만 삭제가 가능합니다!";
        }
        postRepository.deleteById(id);
        List<Reply> reply = replyRepository.findByPostid(id);
        for (int i = 0; i < reply.size(); i++) {
            replyRepository.deleteById(reply.get(i).getReplyid());
        }
        return "ID: ["+id+"]의 삭제 완료";
    }
}
