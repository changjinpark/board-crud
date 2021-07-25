package com.steadyjin.board.springboot.web.dto;

import com.steadyjin.board.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long boardId;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private LocalDateTime createdDate;

    public PostsListResponseDto(Posts entity) {
        this.boardId = entity.getBoardId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.createdDate = entity.getCreatedDate();
    }
}