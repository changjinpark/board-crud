package com.steadyjin.board.springboot.web.dto;

import com.steadyjin.board.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsReadResponseDto {
    private Long boardId;
    private String title;
    private String content;
    private String author;

    public PostsReadResponseDto(Posts posts){
        this.boardId = posts.getBoardId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }
}
