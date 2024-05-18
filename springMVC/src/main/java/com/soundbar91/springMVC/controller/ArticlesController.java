package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.dto.Article;
import com.soundbar91.springMVC.repository.MapArticleRepository;
import com.soundbar91.springMVC.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticlesController {

    private final ArticleService articleService;

    public ArticlesController() {
        this.articleService = new ArticleService();
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok().body(articleService.getAllArticles());
    }

    @GetMapping("/post")
    public String postAllArticles(Model model) {
        List<Article> articles = articleService.getAllArticles();
        model.addAttribute("articlesList", articles);
        return "articles";
    }
}
