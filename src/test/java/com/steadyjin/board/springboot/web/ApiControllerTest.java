package com.steadyjin.board.springboot.web;

import com.steadyjin.board.springboot.domain.posts.Posts;
import com.steadyjin.board.springboot.domain.posts.PostsRepository;
import com.steadyjin.board.springboot.web.dto.PostsCreateRequestDto;
import com.steadyjin.board.springboot.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 등록된다() throws Exception {
        String title = "title";
        String content = "content";

        PostsCreateRequestDto postsCreateRequestDto = PostsCreateRequestDto.builder()
                .title(title)
                .content(content)
                .author("changjin")
                .build();

        String url = "http://localhost:"+port+"/api/board";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, postsCreateRequestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        Posts posts = all.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo("changjin");

    }

    @Test
    public void 수정된다() throws Exception {

        Posts save = postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        Long boardId = save.getBoardId();
        String title = "title2";
        String content = "content2";

        PostsUpdateRequestDto build = PostsUpdateRequestDto.builder().title(title).content(content).build();

        String url = "http://localhost:"+port+"/api/board/"+boardId;


        HttpEntity<PostsUpdateRequestDto> postsUpdateRequestDtoHttpEntity = new HttpEntity<>(build);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, postsUpdateRequestDtoHttpEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        Posts posts = all.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

}
