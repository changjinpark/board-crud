package com.steadyjin.board.springboot.service.posts;

import com.steadyjin.board.springboot.domain.posts.Posts;
import com.steadyjin.board.springboot.domain.posts.PostsRepository;
import com.steadyjin.board.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


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

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostsReadResponseDto findById(Long boardId) {
        Posts posts = postsRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. boardId=" + boardId));
        return new PostsReadResponseDto(posts);
    }

    @Transactional
    public void delete (Long boardId) {
        Posts posts = postsRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. boardId=" + boardId));
        postsRepository.delete(posts);
    }
}
