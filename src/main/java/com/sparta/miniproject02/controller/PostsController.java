package com.sparta.miniproject02.controller;


import com.sparta.miniproject02.domain.Posts;
import com.sparta.miniproject02.dto.PostsRequestDto;
import com.sparta.miniproject02.dto.PostsResponseDto;
import com.sparta.miniproject02.service.PostsService;
import com.sparta.miniproject02.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {


    private final PostsService postsService;
    private final S3Service s3Service;

    //포스팅 전체목록을 리턴한다.
    @GetMapping("/api/posts")
    public List<Posts> findAllPosts(){

        return postsService.findAllPosts();

    }

    //요청값을 받아와 저장한다.
    @PostMapping("/api/posts/write")
    public void Posting(@RequestPart PostsRequestDto postsRequestDto, @RequestPart MultipartFile file) {
        String imgPath = s3Service.upload(file);
        //이미지 경로를 받아온다.
        postsRequestDto.setImgUrl(imgPath);
        //Dto에 담아준뒤 , 서비스 로직에 넘긴다.
        postsService.Posting(postsRequestDto);
    }

    //특정 객체를 찾아서 조회하여준다.
    @GetMapping("/api/posts/{post_id}")
    public PostsResponseDto findByPostId(@PathVariable(value = "post_id") Long postid){

        return postsService.findByPostId(postid);
    }


    //객체 pk를 받아와서 수정 ,
    @PutMapping("/api/posts/modify/{post_id}")
    public Long postModifyById(@PathVariable(value = "post_id") Long postid
            ,@RequestBody PostsRequestDto postsRequestDto){

        return postsService.postUpdate(postid, postsRequestDto);
        //객체가 성공적으로 수정된다면 , pk값을 반환 . -> pk값 활용하여 수정완료후의 페이지로 이동가능하다

    }

    //객체 pk를 받아와 삭제한다.
    @DeleteMapping("/api/posts/delete/{post_id}")
    public void postDeleteById(@PathVariable(value = "post_id") Long postid){

        postsService.postDelete(postid);
    }

}
