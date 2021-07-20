package com.steadyjin.board.springboot.service.posts;

import com.steadyjin.board.springboot.domain.posts.Posts;
import com.steadyjin.board.springboot.domain.posts.PostsRepository;
import com.steadyjin.board.springboot.web.dto.PostsCreateRequestDto;
import com.steadyjin.board.springboot.web.dto.PostsReadResponseDto;
import com.steadyjin.board.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long create(PostsCreateRequestDto postsCreateRequestDto){
        return postsRepository.save(postsCreateRequestDto.toEntity()).getBoardId();
    }

    @Transactional
    public PostsReadResponseDto read(Long boardId){
        Posts posts = postsRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. boardId=" + boardId));

        return new PostsReadResponseDto(posts);
    }

    @Transactional
    public Long update(Long boardId, PostsUpdateRequestDto postsUpdateRequestDto) {
        Posts posts = postsRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. boardId=" + boardId));

        posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());
        return boardId;
    }
}
