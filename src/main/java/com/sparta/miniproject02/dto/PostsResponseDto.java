package com.sparta.miniproject02.dto;


import com.sparta.miniproject02.domain.Comments;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostsResponseDto {


//    private Long id;
    private String username;
    private String contents;
    private String imgUrl;
    private List<Comments> commentsList;


}
