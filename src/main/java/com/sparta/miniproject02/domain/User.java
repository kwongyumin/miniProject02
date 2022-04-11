package com.sparta.miniproject02.domain;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = true)
    private Long kakao_id;

    public User(String username, String password, String gender, Long kakao_id){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.kakao_id = kakao_id;
    }
}
