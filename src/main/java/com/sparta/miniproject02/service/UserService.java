package com.sparta.miniproject02.service;

import com.sparta.miniproject02.domain.User;
import com.sparta.miniproject02.dto.SignupRequestDto;
import com.sparta.miniproject02.exception.UserException;
import com.sparta.miniproject02.exception.UserExceptionType;
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

    //회원 가입 버튼을 최종적으로 클릭한 상태의 결과값을 반환
    public void userRegister(SignupRequestDto signupRequestDto) {

        String userId = signupRequestDto.getUserId();

        String username = signupRequestDto.getUsername();

        //중복검사를 하지 않을 시에, 유저 아이디가 존재한다면 해당 에러를 발생시킨다.
        if (userRepository.findByUserId(userId).isPresent()) {
            throw new UserException(UserExceptionType.ALREADY_EXIST_USERID);
        }

        //중복검사를 하지 않을 시에, 유저 닉네임이 존재한다면 해당 에러를 발생시킨다.
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserException(UserExceptionType.ALREADY_EXIST_USERNAME);
        }

        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        String gender = signupRequestDto.getGender();

        User user = new User(userId, username, password, gender);
        userRepository.save(user);

    }
    //회원가입 버튼 클릭 전 중복검사.
    public void checksId(String userId) {
        Optional<User> getUserId = userRepository.findByUserId(userId);
        if(getUserId.isPresent()){
            throw new UserException(UserExceptionType.ALREADY_EXIST_USERID);
        }

    }

    //회원가입 버튼 클릭 전 중복검사.
    public void checkUsername(String username) {
        Optional<User> getUsername = userRepository.findByUsername(username);
        if(getUsername.isPresent()){
            throw new UserException(UserExceptionType.ALREADY_EXIST_USERNAME);
        }
    }
}