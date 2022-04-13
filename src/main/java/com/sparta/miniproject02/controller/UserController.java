package com.sparta.miniproject02.controller;

import com.sparta.miniproject02.config.JwtTokenProvider;
import com.sparta.miniproject02.config.UserDetailsImpl;
import com.sparta.miniproject02.domain.User;
import com.sparta.miniproject02.dto.SignupRequestDto;
import com.sparta.miniproject02.exception.UserException;
import com.sparta.miniproject02.exception.UserExceptionType;
import com.sparta.miniproject02.repository.UserRepository;
import com.sparta.miniproject02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    //회원가입
    @PostMapping("/api/user/signup")
    public String userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.userRegister(signupRequestDto);
        return "회원가입 성공";

    }

    //아이디 중복확인
    @PostMapping("/api/user/checkid")
    public void checkId(@RequestBody SignupRequestDto signupRequestDto) {

        userService.checksId(signupRequestDto.getUserId());
    }

    //username 중복확인
    @PostMapping("/api/user/checkusername")
    public void checkUsername(@RequestBody SignupRequestDto signupRequestDto){
        userService.checkUsername(signupRequestDto.getUsername());
    }

    //로그인 성공
    @PostMapping("/api/user/login")
    public Map<String,String> login(@RequestBody SignupRequestDto requestDto) {

        //userID dun 9999 / password  132030
        User user = userRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 userId 입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        Map<String,String> result = new HashMap<>();

        result.put("token",jwtTokenProvider.createToken(user.getUserId(), Long.toString(user.getId())));
        result.put("userId",user.getUserId());
        result.put("username",user.getUsername());

        System.out.println("토큰 만들어지나? " + result);


        return result;


    }


    @GetMapping("/auth")
    public Map<String, String> userInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails == null) {
            throw new UserException(UserExceptionType.LOGIN_TOKEN_EXPIRE);
        }
        Map<String, String> result = new HashMap<>();
        result.put("userId", userDetails.getUser().getUserId());
        result.put("username", userDetails.getUsername());
        result.put("result", "success");

        return result;
    }




}