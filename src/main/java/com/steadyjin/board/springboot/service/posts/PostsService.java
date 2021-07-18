package com.steadyjin.board.springboot.service.posts;

import com.steadyjin.board.springboot.domain.posts.PostsRepository;
import com.steadyjin.board.springboot.web.dto.PostsCreateRequestDto;
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
}
