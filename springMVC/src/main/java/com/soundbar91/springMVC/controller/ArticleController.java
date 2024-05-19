package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.dto.RequestArticleDTO;
import com.soundbar91.springMVC.dto.ResponseArticleDTO;
import com.soundbar91.springMVC.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController() {
        this.articleService = new ArticleService();
    }

    @GetMapping("/post")
    public String getAllArticlesPost(Model model) {
        Map<String, List<ResponseArticleDTO>> articlesWithBoard = articleService.getArticlesWithBoard();
        model.addAttribute("articlesWithBoard", articlesWithBoard);
        return "post";
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ResponseArticleDTO>> getAllArticles() {
        return ResponseEntity.ok().body(articleService.getArticles());
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ResponseArticleDTO> getArticleById(@PathVariable("id") Long id) {
        ResponseArticleDTO article = articleService.getArticle(id);
        return article == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok().body(article);
    }

    @PostMapping("/articles")
    public ResponseEntity<Void> createArticle(@RequestBody RequestArticleDTO article) {
        articleService.addArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ResponseArticleDTO> updateArticle(@PathVariable("id") Long id, @RequestBody RequestArticleDTO updatedArticle) {
        return articleService.updateArticle(id, updatedArticle) ?
                ResponseEntity.ok(articleService.getArticle(id)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        return articleService.deleteArticle(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
