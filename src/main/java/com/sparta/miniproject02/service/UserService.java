package com.sparta.miniproject02.service;

import com.sparta.miniproject02.domain.User;
import com.sparta.miniproject02.dto.SignupRequestDto;
import com.sparta.miniproject02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void userRegister(SignupRequestDto signupRequestDto) {
    /*
      private String username;

        private String gender; */
        String username = signupRequestDto.getUsername();

        checksId(username);

        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        String gender = signupRequestDto.getGender();

        User user = new User(username,password,gender);
        userRepository.save(user);

    }

    public String checksId(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return "Existed Id";
        }
        return "You can use this Id";
    }
}