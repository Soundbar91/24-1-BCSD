package com.soundbar91.springMVC.entity;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long authorId;
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime modifiedDate;

    public Article(Long authorId, Long boardId, String title, String content) {
        this.authorId = authorId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;

        this.writeDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    public void updateArticle(String title, String content) {
        this.title = title;
        this.content = content;
        this.modifiedDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
