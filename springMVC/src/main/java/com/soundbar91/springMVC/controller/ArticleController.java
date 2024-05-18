package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.repository.MapArticleRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final MapArticleRepository articleRepository;

    public ArticleController() {
        this.articleRepository = new MapArticleRepository();
    }
}

