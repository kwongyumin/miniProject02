package com.sparta.miniproject02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String password2;
    private String gender;

    public SignupRequestDto(String username, String password, String password2, String gender) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.gender = gender;
    }
}