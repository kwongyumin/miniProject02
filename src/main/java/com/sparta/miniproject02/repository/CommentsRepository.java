package com.sparta.miniproject02.repository;

import com.sparta.miniproject02.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    List<Comments> findByPostsIdOrderByModifiedAtDesc(Long id);
    List<Comments> findByPostsId(Long id);
}
