package com.soundbar91.springJDBC.Article.controller;

import com.soundbar91.springJDBC.Article.dto.RequestArticleDTO;
import com.soundbar91.springJDBC.Article.dto.ResponseArticleDTO;
import com.soundbar91.springJDBC.Article.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(DataSource dataSource) {
        this.articleService = new ArticleService(dataSource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseArticleDTO> getArticleById(@PathVariable("id") Long id) {
        ResponseArticleDTO responseArticleDTO = articleService.getArticleById(id);
        return responseArticleDTO != null ?
                ResponseEntity.status(HttpStatus.OK).body(responseArticleDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ResponseArticleDTO> addArticle(@RequestBody RequestArticleDTO requestArticleDTO) {
        ResponseArticleDTO responseArticleDTO = articleService.addArticle(requestArticleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseArticleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseArticleDTO> updateArticle(@PathVariable("id") Long id, @RequestBody RequestArticleDTO requestArticleDTO) {
        ResponseArticleDTO responseArticleDTO = articleService.updateArticle(id, requestArticleDTO);
        return responseArticleDTO == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(responseArticleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        return articleService.deleteArticle(id) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
