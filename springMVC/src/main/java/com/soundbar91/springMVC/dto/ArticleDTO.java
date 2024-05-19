package com.soundbar91.springMVC.dto;

import java.time.LocalDateTime;

public class ArticleDTO {
    private String title;
    private String author;
    private String content;
    private LocalDateTime writerDate;

    public ArticleDTO(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;

        this.writerDate = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getWriterDate() {
        return writerDate;
    }

    public void setWriterDate(LocalDateTime writerDate) {
        this.writerDate = writerDate;
    }
}
