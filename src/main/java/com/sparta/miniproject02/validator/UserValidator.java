//package com.sparta.miniproject02.validator;
//
//import com.sparta.miniproject02.dto.SignupRequestDto;
//import org.springframework.stereotype.Component;
//
//import java.util.regex.Pattern;
//
//@Component
//public class UserValidator {
//
//    public static void checkPassword(SignupRequestDto signupRequestDto) {
//        if (!signupRequestDto.getPassword().equals(signupRequestDto.getPasswordCheck())) {
//            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
//        }
//    }
//    public static void checkForm(String username, String password, String email) {
//        if(username.equals("")) {
//            throw new IllegalArgumentException("아아디는 필수 입력 값 입니다");
//        }
//        if(password.equals("")) {
//            throw new IllegalArgumentException("비밀번호는 필수 입력 값 입니다");
//        }
//
//
//        if(!Pattern.matches("^[a-zA-Z0-9]{4,12}$",username)) {
//            throw new IllegalArgumentException("아이디는 대문자,소문자,숫자로 이루어진 4~12자여야 합니다.");
//        }
//        if(!Pattern.matches("^.{4,}$",password)) {
//            throw new IllegalArgumentException("비밀번호는 4자이상의 비밀번호여야 합니다.");
//        }
//
//        if(password.contains(username)) {
//            throw new IllegalArgumentException("비밀번호에 아이디와 같은 값을 포함할 수 없습니다.");
//        }
//    }
//
//
//
//}