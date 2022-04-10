package com.sparta.miniproject02.domain;


import com.sparta.miniproject02.dto.PostsRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Posts extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="posts_id")
    private Long id;

    @Column(nullable = false)
    private String contents;


    @Column(columnDefinition = "TEXT")
    private String imgUrl;
    //546546465453

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "posts" , cascade = CascadeType.REMOVE)
    private List<Comments> commentsList;





    //내용 수정, //사진 수정 생각해야됨.
    public void update(PostsRequestDto postsRequestDto) {

        this.contents = postsRequestDto.getContents();

    }
}

