package com.soundbar91.springMVC.entity;

import com.soundbar91.springMVC.dto.ArticleDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Article {
    private long articleId;
    private String writerId;
    private long boardId;
    private String title;
    private String content;
    private LocalDateTime writerDate;
    private LocalDateTime modifyDate;

    public Article(ArticleDTO articleDTO, long boardId) {
        this.articleId = articleDTO.get
        this.title = articleDTO.getTitle();
        this.content = articleDTO.getContent();
        this.writerId = articleDTO.getAuthor();
        this.writerDate = articleDTO.getWriterDate();
        this.modifyDate = null;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}
