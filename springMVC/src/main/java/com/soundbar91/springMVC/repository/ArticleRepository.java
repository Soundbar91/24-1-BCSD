package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.entity.Article;

import java.util.List;

public interface ArticleRepository {

    Article getArticleById(Long id);
    List<Article> getAllArticles();
    void addArticle(Article article);
    boolean updateArticle(Article updatedArticle);
    boolean deleteArticle(Long id);
}
