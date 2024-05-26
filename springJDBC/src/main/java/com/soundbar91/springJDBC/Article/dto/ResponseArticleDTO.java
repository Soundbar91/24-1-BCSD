package com.soundbar91.springJDBC.Article.dto;

import com.soundbar91.springJDBC.Article.entity.Article;

import java.time.LocalDateTime;

public record ResponseArticleDTO (
        Long id,
        Long author_id,
        Long board_id,
        String title,
        String content,
        LocalDateTime created_date,
        LocalDateTime modified_date
) {
    public static ResponseArticleDTO of(Article article) {
        return new ResponseArticleDTO(
                article.getId(),
                article.getAuthor_id(),
                article.getBoard_id(),
                article.getTitle(),
                article.getContent(),
                article.getCreated_data(),
                article.getModified_data());
    }
}
