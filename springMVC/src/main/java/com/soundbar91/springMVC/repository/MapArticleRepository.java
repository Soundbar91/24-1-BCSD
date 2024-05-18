package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.dto.Article;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapArticleRepository implements ArticleRepository {

    private static final Map<Long, Article> articles = new HashMap<>();
    private long currentId = 1;

    @Override
    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    @Override
    public Article getArticleById(Long id) {
        return articles.getOrDefault(id, null);
    }

    @Override
    public void addArticle(Article article) {
        article.setArticleId(currentId++);
        articles.put(article.getArticleId(), article);
    }

    @Override
    public boolean updateArticle(Long id, Article updatedArticle) {
        if (!articles.containsKey(id)) return false;
        else {
            Article article = articles.get(id);
            article.setTitle(updatedArticle.getTitle());
            article.setContent(updatedArticle.getContent());
            article.setModifyDate(Calendar.getInstance());
            articles.put(id, article);

            return true;
        }
    }

    @Override
    public boolean deleteArticle(Long id) {
        if (!articles.containsKey(id)) return false;
        else {
            articles.remove(id);
            return true;
        }
    }
}
