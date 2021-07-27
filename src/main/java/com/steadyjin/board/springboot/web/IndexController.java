package com.steadyjin.board.springboot.web;

import com.steadyjin.board.springboot.config.auth.LoginUser;
import com.steadyjin.board.springboot.config.auth.dto.SessionUser;
import com.steadyjin.board.springboot.service.posts.PostsService;
import com.steadyjin.board.springboot.web.dto.PostsReadResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        //SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
            System.out.println(user.getName());
        }
        return "index";
    }

    @GetMapping("/board/create")
    public String board_create() {
        return "board-create";
    }

    @GetMapping("/board/update/{boardId}")
    public String board_update(@PathVariable Long boardId, Model model) {
        PostsReadResponseDto postsReadResponseDto = postsService.findById(boardId);
        model.addAttribute("post", postsReadResponseDto);
        return "board-update";
    }

}
