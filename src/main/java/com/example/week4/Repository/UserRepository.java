package com.example.week4.Repository;


import com.example.week4.Entity.Auther;
import com.example.week4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Auther> findByUsername(String username);
}