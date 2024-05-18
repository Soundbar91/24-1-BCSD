package com.soundbar91.springMVC.service;

import com.soundbar91.springMVC.dto.Article;
import com.soundbar91.springMVC.repository.MapArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final MapArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = new MapArticleRepository();
    }

    public Article getArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }

    public void addArticle(Article article) {
        articleRepository.addArticle(article);
    }

    public boolean updateArticle(Long id, Article article) {
        return articleRepository.updateArticle(id, article);
    }

    public boolean deleteArticle(Long id) {
        return articleRepository.deleteArticle(id);
    }

    public List<Article> getAllArticles() {
        return articleRepository.getAllArticles();
    }
}
