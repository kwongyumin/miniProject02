package com.sparta.miniproject02.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostsResponseDto {


    private Long id;
    private String username;
    private String contents;
    private String imgUrl;


}
