package com.example.demo2.service; //3

import com.example.demo2.dto.UserRequestDto;
import com.example.demo2.dto.UserResponseDto;
import com.example.demo2.entity.User;
import com.example.demo2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto register(UserRequestDto requestDto) {
        User user = new User(requestDto.getUsername(), requestDto.getPassword());
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser.getId(), savedUser.getUsername());
    }

    public boolean login(UserRequestDto requestDto) {
        return userRepository.findByUsername(requestDto.getUsername())
                .map(user -> user.getPassword().equals(requestDto.getPassword()))
                .orElse(false);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDto(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserResponseDto(user.getId(), user.getUsername()));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
