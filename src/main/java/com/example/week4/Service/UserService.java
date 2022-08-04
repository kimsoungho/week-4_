package com.example.week4.Service;

import com.example.week4.Dto.SignupRequestDto;
import com.example.week4.Entity.Auther;
import com.example.week4.Entity.User;
import com.example.week4.Entity.UserRoleEnum;
import com.example.week4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;



    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        // 회원 ID 중복 확인
        Optional<Auther> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }


        User user = new User(username, password);
        userRepository.save(user);
    }
    }

