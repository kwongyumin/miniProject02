package com.sparta.miniproject02.controller;

import com.sparta.miniproject02.dto.CommentsRequestDto;
import com.sparta.miniproject02.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="*")
public class CommentsController {

    private final CommentsService commentsService;

    //댓글 작성
    @PostMapping("/api/comments/{postId}")
    public void createComments(
            @PathVariable Long postId,
            @RequestBody CommentsRequestDto commentsRequestDto){
        commentsService.createComments(postId, commentsRequestDto);

    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public Long deleteComments(@PathVariable Long commentId){
        return commentsService.deleteComments(commentId);

    }

    //댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public Long updateComments(@PathVariable Long commentId,
                               @RequestBody CommentsRequestDto commentsRequestDto){
        return commentsService.updateComments(commentId, commentsRequestDto);
    }


}
