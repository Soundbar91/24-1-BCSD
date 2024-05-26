package com.soundbar91.springJDBC.Article.repository;

import com.soundbar91.springJDBC.Article.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    Optional<Article> getArticleById(Long id);
    List<Article> getArticlesByBoard(Long boardId);
    void addArticle(Article article);
    void updateArticle(Long id, Article updatedArticle);
    boolean deleteArticle(Long id);
}
