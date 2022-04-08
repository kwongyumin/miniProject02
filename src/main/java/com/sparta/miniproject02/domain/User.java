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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String gender;

    @Column
    private Long kakao_id;


}
