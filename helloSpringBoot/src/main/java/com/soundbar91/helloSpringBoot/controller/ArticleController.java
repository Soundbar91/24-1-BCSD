package com.soundbar91.helloSpringBoot.controller;

import com.soundbar91.helloSpringBoot.dto.Article;
import com.soundbar91.helloSpringBoot.repository.MemoryArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final MemoryArticleRepository articleRepository;

    public ArticleController() {
        this.articleRepository = new MemoryArticleRepository();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
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
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        return articleRepository.updateArticle(id, updatedArticle) ?
                ResponseEntity.ok(articleRepository.getArticleById(id)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        return articleRepository.deleteArticle(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Article> patchArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        return articleRepository.patchArticle(id, updatedArticle) ?
                ResponseEntity.ok(articleRepository.getArticleById(id)) : ResponseEntity.notFound().build();
    }
}
