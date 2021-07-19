package com.steadyjin.board.springboot.web;

import com.steadyjin.board.springboot.service.posts.PostsService;
import com.steadyjin.board.springboot.web.dto.PostsCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final PostsService postsService;

    @PostMapping("/api/board")
    public Long create(@RequestBody PostsCreateRequestDto postsCreateRequestDto){

        return postsService.create(postsCreateRequestDto);
    }

}
