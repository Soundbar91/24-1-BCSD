package com.soundbar91.springMVC.dto;

public class RequestArticleDTO {
    private Long authorId;
    private Long boardId;
    private String title;
    private String content;

    public RequestArticleDTO() {
    }

    public RequestArticleDTO(Long authorId, Long boardId, String title, String content) {
        this.authorId = authorId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
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
}
