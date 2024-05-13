package com.soundbar91.helloSpringBoot.repository;

import com.soundbar91.helloSpringBoot.dto.Article;


public interface ArticleRepository {

    Article getArticleById(Long id);

    void addArticle(Article article);

    boolean updateArticle(Long id, Article updatedArticle);

    boolean deleteArticle(Long id);

    boolean patchArticle(Long id, Article updatedArticle);
}
