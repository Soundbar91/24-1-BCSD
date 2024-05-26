package com.soundbar91.springJDBC.Article.entity;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long author_id;
    private Long board_id;
    private String title;
    private String content;
    private LocalDateTime created_data;
    private LocalDateTime modified_data;

    public Article(Long authorId, Long boardId, String title, String content, LocalDateTime writeDate, LocalDateTime modifiedDate) {
        this.author_id = authorId;
        this.board_id = boardId;
        this.title = title;
        this.content = content;
        this.created_data = writeDate;
        this.modified_data = modifiedDate;
    }

    public void updateArticle(Long BoardId, String title, String content, LocalDateTime modifiedDate) {
        this.board_id = BoardId;
        this.title = title;
        this.content = content;
        this.modified_data = modifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public Long getBoard_id() {
        return board_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_data() {
        return created_data;
    }

    public LocalDateTime getModified_data() {
        return modified_data;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author_id=" + author_id +
                ", board_id=" + board_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_data=" + created_data +
                ", modified_data=" + modified_data +
                '}';
    }
}
