package com.sparta.miniproject02.controller;


import com.sparta.miniproject02.domain.Comments;
import com.sparta.miniproject02.domain.Posts;
import com.sparta.miniproject02.dto.PostsRequestDto;
import com.sparta.miniproject02.dto.PostsResponseDto;
import com.sparta.miniproject02.repository.CommentsRepository;
import com.sparta.miniproject02.service.PostsService;
import com.sparta.miniproject02.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="http://localhost:3000, http://3.35.27.159:8080")
public class PostsController {

    private final CommentsRepository commentsRepository;
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
    public Map<String,Object> findByPostId(@PathVariable(value = "post_id") Long postid){

        Map<String,Object> result = new HashMap<>();

        PostsResponseDto postsResponseDto = postsService.findByPostId(postid);

        result.put("contents",postsResponseDto.getContents());
        result.put("imgUrl",postsResponseDto.getImgUrl());

        List<Comments> commentsList = commentsRepository.findByPostsIdOrderByModifiedAtDesc(postsResponseDto.getId());


        Map<Long,String>getCommentsByList = new HashMap<>();

        for(Comments comments : commentsList){
            Long id = comments.getId();
            String contents = comments.getContents();
            getCommentsByList.put(id,contents);
        }


        result.put("comments",getCommentsByList);

        return result;
    }


    //객체 pk를 받아와서 수정 ,
    @PutMapping("/api/posts/modify/{post_id}")
    public Long postModifyById(@PathVariable(value = "post_id") Long postid
            ,@RequestPart PostsRequestDto postsRequestDto, @RequestPart MultipartFile file){

        //파일을 받아와서 기존의 저장되어있는 값은 삭제한뒤 , 포스트 업데이트,
        String imgPath = s3Service.upload(file,postsRequestDto.getImgUrl());

        postsRequestDto.setImgUrl(imgPath);
        return postsService.postUpdate(postid, postsRequestDto);
        //객체가 성공적으로 수정된다면 , pk값을 반환 . -> pk값 활용하여 수정완료후의 페이지로 이동가능하다

    }

    //객체 pk를 받아와 삭제한다.
    @DeleteMapping("/api/posts/delete/{post_id}")
    public void postDeleteById(@PathVariable(value = "post_id") Long postid){

        postsService.postDelete(postid);
    }

}
