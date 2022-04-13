package com.sparta.miniproject02.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeRequestDto {
//    //좋아요 누른 유저의 id
//    private Long likeUserId;
    //좋아요가 눌린 게시글의 id
    private Long postId;
}
