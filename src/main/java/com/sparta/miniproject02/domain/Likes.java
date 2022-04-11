package com.sparta.miniproject02.domain;

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

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "posts_id")
//    private Posts posts;

    @Column
    private Long postsId;

    @Column
    private Long likeUserId;

    public Likes(Long likeUserId, Long postsId){
        this.postsId = postsId;
        this.likeUserId = likeUserId;
    }

}
