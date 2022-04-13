package com.sparta.miniproject02.service;

import com.sparta.miniproject02.config.UserDetailsImpl;
import com.sparta.miniproject02.domain.Comments;
import com.sparta.miniproject02.domain.Posts;
import com.sparta.miniproject02.dto.CommentsRequestDto;
import com.sparta.miniproject02.repository.CommentsRepository;
import com.sparta.miniproject02.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    //댓글 작성
    @Transactional
    public void createComments(Long postId, CommentsRequestDto commentsRequestDto, UserDetailsImpl userDetails) {
        Posts posts = postsRepository.findById(postId).orElseThrow(
                () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );

        Comments comments = new Comments(commentsRequestDto,posts,userDetails.getUsername());
        commentsRepository.save(comments);
    }

    //댓글 삭제
    public Long deleteComments(Long commentId) {
        commentsRepository.deleteById(commentId);
        return commentId;
    }

    //댓글 수정
    @Transactional
    public Long updateComments(Long commentId, CommentsRequestDto commentsRequestDto) {
        Comments comments = commentsRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("해당 댓글이 존재하지 않습니다.")
        );
        return comments.update(commentsRequestDto);
    }

    //댓글 갯수
    public int commentCnt(Long postId) {
        List<Comments> commentsList = commentsRepository.findByPostsId(postId);
        List<Comments> comment = new ArrayList<>();
        for (Comments comments : commentsList){
            comment.add(comments);
        }
      int commentCnt = comment.size();
        return commentCnt;
    }
}
