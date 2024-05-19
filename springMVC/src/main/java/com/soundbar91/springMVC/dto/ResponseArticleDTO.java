package com.soundbar91.springMVC.dto;

import java.time.LocalDateTime;

public class ResponseArticleDTO {
    private String title;
    private String author;
    private String content;
    private LocalDateTime writeDate;

    public ResponseArticleDTO() {
    }

    public ResponseArticleDTO(String title, String author, String content, LocalDateTime writeDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.writeDate = writeDate;
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
