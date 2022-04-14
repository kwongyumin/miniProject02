package com.sparta.miniproject02.domain;


import com.sparta.miniproject02.config.UserDetailsImpl;
import com.sparta.miniproject02.dto.CommentsRequestDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Comments extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "posts_id",nullable = false)
    private Posts posts;





    public Comments(CommentsRequestDto commentsRequestDto, Posts posts){
        this.contents = commentsRequestDto.getContents();
        this.posts = posts;
    }


    public Long update(CommentsRequestDto commentsRequestDto) {
        this.contents = commentsRequestDto.getContents();
        return id;
    }
}
