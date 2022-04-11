package com.sparta.miniproject02.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.miniproject02.domain.User;
import com.sparta.miniproject02.dto.SignupRequestDto;
import com.sparta.miniproject02.repository.UserRepository;
import com.sparta.miniproject02.security.UserDetailsImpl;
import com.sparta.miniproject02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    private final KakaoUserService kakaoUserService;


    //회원가입
    @PostMapping("/api/user/signup")
    public String userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.userRegister(signupRequestDto);
        return "회원가입 성공";

    }

    //로그인 성공
    @PostMapping("/api/user/login")
    public List<Map<String,String>> login(@RequestBody SignupRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 username 입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        Map<String,String> username =new HashMap<>();
        Map<String,String>token = new HashMap<>();
        List<Map<String,String>> tu = new ArrayList<>(); // -> 리스트를 만드는데, Map형태(키:밸류 형태)의 변수들을 담을 것이다.
//        token.put("token",jwtTokenProvider.createToken(Long.toString(member.getId()),member.getUsername())); // "username" : {username}
        token.put("token",jwtTokenProvider.createToken(user.getUsername(), Long.toString(user.getId())));
        username.put("username",user.getUsername()); // "token" : {token}
        tu.add(username); //List형태 ["username" : {username}]
        tu.add(token); //List형태 ["token" : {token}]
        return tu; // List형태 ["username" : {username}, "token" : {token}]
    }




    //카카오 회원가입 및 로그인 요청 처리
    @GetMapping("/user/kakao/callback")
    public List<Map<String,String>> kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return kakaoUserService.kakaoLogin(code, response);
    }


    //아이디 중복확인
    @PostMapping("/api/user/checkid")
    public String checkId(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.checksId(signupRequestDto.getUsername());
    }

}