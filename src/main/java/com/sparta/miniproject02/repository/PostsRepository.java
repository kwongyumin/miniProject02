package com.sparta.miniproject02.repository;

import com.sparta.miniproject02.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostsRepository extends JpaRepository<Posts,Long> {
    //전체 게시물을 시간순에 의해 내림차순 .
    List<Posts> findAllByOrderByModifiedAtDesc();
}
