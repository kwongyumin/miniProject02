package com.sparta.miniproject02.service;

import com.sparta.miniproject02.domain.Likes;
import com.sparta.miniproject02.domain.Posts;
import com.sparta.miniproject02.dto.LikeRequestDto;
import com.sparta.miniproject02.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikesRepository likesRepository;
    private final PostsRepository postsRepository;

    public boolean getLikes(LikeRequestDto likeRequestDto) {
        Long postId = likeRequestDto.getPostId();
        Long likeUser = likeRequestDto.getLikeUserId();
//        Posts posts = postsRepository.findById(postId).orElseThrow(
//                () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
//        );
        Optional<Likes> likes = likesRepository.findByPosts_IdAndUser_Id(postId, likeUser);

        // isPresent을 사용하기 위해선 Optional 로 감싸야 함
        // 반환값이 null 값 여부 확인, null을 반환하면서 발생되는 오류를 줄여줌
        //isPresent() = !=null과 같은 뜻. 즉, null이 아니라면, 지워라
        if (likes.isPresent()){
            likesRepository.deleteById(likes.get().getId());
            return false;
        }else {
            Likes likes1 = new Likes(postId, likeUser);
            likesRepository.save(likes1);
            return true;
        }



    }
}
