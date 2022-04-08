package com.sparta.miniproject02.repository;

import com.sparta.miniproject02.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
