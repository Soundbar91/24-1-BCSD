package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.dto.Article;
import com.soundbar91.springMVC.repository.MapArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/article", "/articles"})
public class ArticleController {

    private final MapArticleRepository articleRepository;

    public ArticleController() {
        this.articleRepository = new MapArticleRepository();
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok().body(articleRepository.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
        return Optional.ofNullable(articleRepository.getArticleById(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        articleRepository.addArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody Article updatedArticle) {
        return articleRepository.updateArticle(id, updatedArticle) ?
                ResponseEntity.ok(articleRepository.getArticleById(id)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        return articleRepository.deleteArticle(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

