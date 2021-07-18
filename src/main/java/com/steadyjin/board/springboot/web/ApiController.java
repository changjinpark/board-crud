package com.steadyjin.board.springboot.web;

import com.steadyjin.board.springboot.service.posts.PostsService;
import com.steadyjin.board.springboot.web.dto.PostsCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final PostsService postsService;

    @PostMapping("/api/board")
    public Long create(PostsCreateRequestDto postsCreateRequestDto){

        return postsService.create(postsCreateRequestDto);
    }

}
