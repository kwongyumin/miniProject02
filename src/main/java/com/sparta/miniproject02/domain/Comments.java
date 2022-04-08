package com.sparta.miniproject02.domain;


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

    @Column
    private String contents;

    @ManyToOne
    @JoinColumn(name = "posts_id",nullable = false)
    private Posts posts;


}
