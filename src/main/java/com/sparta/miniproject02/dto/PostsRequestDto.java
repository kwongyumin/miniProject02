package com.sparta.miniproject02.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostsRequestDto {


    private String username;
    private String contents;
    private String imgUrl;


}
