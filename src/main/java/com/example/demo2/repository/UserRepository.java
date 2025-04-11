package com.example.demo2.repository; //2

import com.example.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// 로그인 기능때 사용예정
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
