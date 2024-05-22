package com.soundbar91.springMVC.dto;

import com.soundbar91.springMVC.entity.Article;

import java.time.LocalDateTime;

public class ResponseArticleDTO {
    private String title;
    private String author;
    private String content;
    private LocalDateTime writeDate;

    public ResponseArticleDTO(Article article, String name) {
        this.title = article.getTitle();
        this.author = name;
        this.content = article.getContent();
        this.writeDate = article.getWriteDate();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }
}
