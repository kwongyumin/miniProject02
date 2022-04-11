package com.sparta.miniproject02.service;

import com.sparta.miniproject02.domain.User;
import com.sparta.miniproject02.repository.UserRepository;
import com.sparta.miniproject02.userdto.SignupRequestDto;
import lombok.RequiredArgsConstructor;import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;




    public String checksId(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return "Existed Id";
        }
        return "You can use this Id";
    }

    public String gender(String gender) {
        Optional<User> user = userRepository.findByEmail(gender);
        if (user.isPresent()) {
            return "Existed gender";
        }
        return "You can use this gender";
    }

}