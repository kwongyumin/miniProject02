package com.sparta.miniproject02.controller;

import com.sparta.miniproject02.config.UserDetailsImpl;
import com.sparta.miniproject02.dto.LikeRequestDto;
import com.sparta.miniproject02.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    //return 값은 참 또는 거짓
    @PostMapping("/api/posts/like")
    public boolean getLikes(@RequestBody LikeRequestDto likeRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.getLikes(likeRequestDto, userDetails);
    }

}
