package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.dto.Article;
import com.soundbar91.springMVC.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    private final ArticleService articleService;

    public PostController() {
        this.articleService = new ArticleService();
    }

    @GetMapping("/post")
    public String postAllArticles(Model model) {
        List<Article> articles = articleService.getAllArticles();
        model.addAttribute("articlesList", articles);
        return "articles";
    }
}
