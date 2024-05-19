package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.dto.Article;
import com.soundbar91.springMVC.repository.MapArticleRepository;
import com.soundbar91.springMVC.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController() {
        this.articleService = new ArticleService();
    }

    @GetMapping()
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok().body(articleService.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
        Article article = articleService.getArticleById(id);
        return article == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(article);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        articleService.addArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody Article updatedArticle) {
        return articleService.updateArticle(id, updatedArticle) ?
                ResponseEntity.ok(articleService.getArticleById(id)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        return articleService.deleteArticle(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

