package com.sparta.miniproject02.controller;

import com.sparta.miniproject02.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;


}
