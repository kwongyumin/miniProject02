package com.sparta.miniproject02.controller;

import com.sparta.miniproject02.config.JwtTokenProvider;
import com.sparta.miniproject02.config.UserDetailsImpl;
import com.sparta.miniproject02.domain.User;
import com.sparta.miniproject02.dto.SignupRequestDto;
import com.sparta.miniproject02.repository.UserRepository;
import com.sparta.miniproject02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @PostMapping("/api/user/checkusername")
    public void checkUsername(@RequestBody SignupRequestDto signupRequestDto){
        userService.checkUsername(signupRequestDto.getUsername());
    }

    //로그인 성공
    @PostMapping("/api/user/login")
    public List<Map<String,String>> login(@RequestBody SignupRequestDto requestDto) {

        //userID dun 9999 / password  132030
        User user = userRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 userId 입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        Map<String,String> userId =new HashMap<>();
        Map<String,String>token = new HashMap<>();
        List<Map<String,String>> tu = new ArrayList<>(); // -> 리스트를 만드는데, Map형태(키:밸류 형태)의 변수들을 담을 것이다.
//        token.put("token",jwtTokenProvider.createToken(Long.toString(member.getId()),member.getUsername())); // "username" : {username}
        token.put("token",jwtTokenProvider.createToken(user.getUserId(), Long.toString(user.getId())));
        userId.put("userId",user.getUserId()); // "token" : {token}
        tu.add(userId); //List형태 ["username" : {username}]
        tu.add(token); //List형태 ["token" : {token}]
        return tu; // List형태 ["username" : {username}, "token" : {token}]
    }




//
//    //카카오 회원가입 및 로그인 요청 처리
//    @GetMapping("/user/kakao/callback")
//    public List<Map<String,String>> kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
//        return kakaoUserService.kakaoLogin(code, response);
//    }




}