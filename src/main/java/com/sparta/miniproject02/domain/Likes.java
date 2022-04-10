package com.sparta.miniproject02.domain;

import com.sparta.miniproject02.dto.LikeRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Likes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Heart_Id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posts_id")
    private Posts posts;

    private Long likeUserId;

    public Likes(LikeRequestDto requestDto, Posts posts){
        this.likeUserId = requestDto.getLikeUserId();
        this.posts = posts;
    }

}
