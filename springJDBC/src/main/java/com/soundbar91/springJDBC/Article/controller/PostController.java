package com.soundbar91.springJDBC.Article.controller;

import com.soundbar91.springJDBC.Article.dto.ResponseArticleDTO;
import com.soundbar91.springJDBC.Article.entity.Article;
import com.soundbar91.springJDBC.Article.service.ArticleService;
import com.soundbar91.springJDBC.Board.dto.ResponseBoardDTO;
import com.soundbar91.springJDBC.Board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class PostController {

    private final ArticleService articleService;
    private final BoardService boardService;

    public PostController(DataSource dataSource) {
        this.articleService = new ArticleService(dataSource);
        this.boardService = new BoardService(dataSource);
    }

    @GetMapping("/posts")
    public String getPost(@RequestParam("boardId") Long boardId, Model model) {
        ResponseBoardDTO boardById = boardService.getBoardById(boardId);
        model.addAttribute("boardName", boardById.title());

        List<ResponseArticleDTO> articleByBoardId = articleService.getArticleByBoardId(boardId);
        model.addAttribute("articles", articleByBoardId);

        return "post";
    }
}
