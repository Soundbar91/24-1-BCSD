package com.soundbar91.springMVC.dto;

import java.util.Calendar;

public class Article {
    private long articleId;
    private String writerId;
    private long boardId;
    private String title;
    private String content;
    private Calendar writerDate;
    private Calendar modifyDate;

    public Article(long articleId, String writerId, long boardId, String title, String content) {
        this.articleId = articleId;
        this.writerId = writerId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;

        writerDate = Calendar.getInstance();
        modifyDate = null;
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

    public Calendar getWriterDate() {
        return writerDate;
    }

    public void setWriterDate(Calendar writerDate) {
        this.writerDate = writerDate;
    }

    public Calendar getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Calendar modifyDate) {
        this.modifyDate = modifyDate;
    }
}
