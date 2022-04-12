package com.sparta.miniproject02.controller;

import com.sparta.miniproject02.dto.LikeRequestDto;
import com.sparta.miniproject02.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="http://localhost:3000, http://3.35.27.159:8080")
public class LikesController {
    private final LikesService likesService;

    //return 값은 참 또는 거짓
    @PostMapping("/api/posts/like")
    public boolean getLikes(@RequestBody LikeRequestDto likeRequestDto){
        return likesService.getLikes(likeRequestDto);
    }

}
