package com.soundbar91.springJDBC.Article.dto;

public record RequestArticleDTO (
        Long boardId,
        Long authorId,
        String title,
        String content
) {

}
