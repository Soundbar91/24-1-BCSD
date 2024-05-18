package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.dto.Article;

import java.util.Collection;

public interface ArticleRepository {

    Collection<Article> getAllArticles();
    Article getArticleById(Long id);
    void addArticle(Article article);
    boolean updateArticle(Long id, Article updatedArticle);
    boolean deleteArticle(Long id);
}