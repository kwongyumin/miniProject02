package com.sparta.miniproject02.service;


import com.sparta.miniproject02.domain.Posts;
import com.sparta.miniproject02.dto.PostsRequestDto;
import com.sparta.miniproject02.dto.PostsResponseDto;
import com.sparta.miniproject02.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    //전체 포스팅 목록을 조회하여 값을 반환해준다.
    @Transactional
    public List<Posts> findAllPosts() {

        return postsRepository.findAllByOrderByModifiedAtDesc();
    }



    // 단일 객체 저장 
    @Transactional
    public void Posting(PostsRequestDto postsRequestDto) {

        Posts posts = Posts.builder()
                //.user() JWT 사용
                .contents(postsRequestDto.getContents())
                .imgUrl(postsRequestDto.getImgUrl())
                .build();

        postsRepository.save(posts);
    }
    // 단일 객체를 찾아서 반환
    @Transactional
    public PostsResponseDto findByPostId(Long postid) {

         Optional<Posts> findPost = postsRepository.findById(postid);
         Posts posts = findPost.orElseThrow( () -> new IllegalArgumentException("존재하지 않는 게시글입니다."));


         return PostsResponseDto.builder()
                 .id(posts.getId())
                 .contents(posts.getContents())
                 .build();

    }
    // 객체 수정
    @Transactional
    public Long postUpdate(Long postid, PostsRequestDto postsRequestDto) {

        Optional<Posts> findPost = postsRepository.findById(postid);
        Posts posts = findPost.orElseThrow( () -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

  
        posts.update(postsRequestDto);
        
        return posts.getId();

    }
    
    // 객체 삭제
    @Transactional
    public void postDelete(Long postid) {
    
        postsRepository.deleteById(postid);
    
    }
}
