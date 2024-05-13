package com.soundbar91.helloSpringBoot.repository;

import com.soundbar91.helloSpringBoot.dto.Article;

import java.util.HashMap;
import java.util.Map;

public class MemoryArticleRepository implements ArticleRepository {
    private final Map<Long, Article> articleMap = new HashMap<>();
    private long currentId = 1;

    @Override
    public Article getArticleById(Long id) {
        return articleMap.get(id);
    }

    @Override
    public void addArticle(Article article) {
        article.setId(currentId);
        articleMap.put(currentId, article);
        currentId++;
    }

    @Override
    public boolean updateArticle(Long id, Article updatedArticle) {
        Article article = articleMap.get(id);
        if (article != null) {
            article.setTitle(updatedArticle.getTitle());
            article.setContent(updatedArticle.getContent());
            articleMap.put(id, article);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteArticle(Long id) {
        if (!articleMap.containsKey(id)) return false;
        else {
            articleMap.remove(id);
            return true;
        }
    }

    @Override
    public boolean patchArticle(Long id, Article updatedArticle) {
        Article article = articleMap.get(id);

        if (article == null) return false;

        if (updatedArticle.getTitle() != null) article.setTitle(updatedArticle.getTitle());
        if (updatedArticle.getContent() != null) article.setContent(updatedArticle.getContent());

        articleMap.put(id, article);
        return true;
    }
}
