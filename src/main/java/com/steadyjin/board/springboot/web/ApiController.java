package com.steadyjin.board.springboot.web;

import com.steadyjin.board.springboot.service.posts.PostsService;
import com.steadyjin.board.springboot.web.dto.PostsCreateRequestDto;
import com.steadyjin.board.springboot.web.dto.PostsReadResponseDto;
import com.steadyjin.board.springboot.web.dto.PostsUpdateRequestDto;
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

    @GetMapping("/api/board/{boardId}")
    public PostsReadResponseDto Read(@PathVariable Long boardId){
        return postsService.read(boardId);
    }

    @PutMapping("/api/board/{boardId}")
    public Long update(@PathVariable Long boardId, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto){
        return postsService.update(boardId, postsUpdateRequestDto);
    }

    @DeleteMapping("/api/board/{boardId}")
    public Long delete(@PathVariable Long boardId){
        postsService.delete(boardId);
        return boardId;
    }

}
