package com.sparta.miniproject02.repository;

import com.sparta.miniproject02.domain.Comments;

import java.util.ArrayList;
import java.util.List;

public class MockCommentsRepository {

    private List<Comments> comments = new ArrayList<>();

    //댓글 테이블 ID: 1부터 시작
    private Long comments_id = 1L;

    //    이미 저장된 댓글  -> 변경 댓글로 업데이트
    public Comments save(Comments comment) {
        for (Comments existComment : comments) {
            if (existComment.getId().equals(comment.getId())) {
                String myComment = comment.getContents();
                existComment.setContents(myComment);
                return existComment;
            }
        }
        // 신규 댓글 -> DB 에 저장
        comment.setId(comments_id);
        ++comments_id;
        comments.add(comment);
        return comment;
    }
}
