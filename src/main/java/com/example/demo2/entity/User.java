package com.example.demo2.entity; // 1

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    //로그인 dto 생성해서 사용할 예정
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
