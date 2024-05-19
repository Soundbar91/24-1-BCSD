package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.entity.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryArticleRepository implements ArticleRepository {

    private final Map<Long, Article> articleMap = new HashMap<>();
    private long currentId = 0;

    @Override
    public Article getArticleById(Long id) {
        return articleMap.get(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return new ArrayList<>(articleMap.values());
    }

    @Override
    public void addArticle(Article article) {
        article.setId(currentId);
        articleMap.put(currentId++, article);
    }

    @Override
    public boolean updateArticle(Article updatedArticle) {
        articleMap.put(updatedArticle.getId(), updatedArticle);
        return true;
    }

    @Override
    public boolean deleteArticle(Long id) {
        if (!articleMap.containsKey(id)) return false;
        articleMap.remove(id);
        return true;
    }
}
