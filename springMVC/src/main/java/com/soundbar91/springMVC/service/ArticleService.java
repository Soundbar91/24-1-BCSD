package com.soundbar91.springMVC.service;

import com.soundbar91.springMVC.repository.MapArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final MapArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = new MapArticleRepository();
    }


}
