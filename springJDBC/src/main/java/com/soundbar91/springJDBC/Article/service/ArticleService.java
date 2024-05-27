package com.soundbar91.springJDBC.Article.service;

import com.soundbar91.springJDBC.Article.dto.RequestArticleDTO;
import com.soundbar91.springJDBC.Article.dto.ResponseArticleDTO;
import com.soundbar91.springJDBC.Article.entity.Article;
import com.soundbar91.springJDBC.Article.repository.ArticleRepository;
import com.soundbar91.springJDBC.Article.repository.JdbcTemplateArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(DataSource dataSource) {
        this.articleRepository = new JdbcTemplateArticleRepository(dataSource);
    }

    public List<ResponseArticleDTO> getArticleByBoardId(Long boardId) {
        List<ResponseArticleDTO> responseArticleDTOList = new ArrayList<>();
        List<Article> articlesByBoard = articleRepository.getArticlesByBoard(boardId);

        for (Article article : articlesByBoard)
            responseArticleDTOList.add(ResponseArticleDTO.of(article));

        return responseArticleDTOList;
    }

    public ResponseArticleDTO getArticleById(Long articleId) {
        return articleRepository.getArticleById(articleId)
                .map(ResponseArticleDTO::of)
                .orElse(null);
    }

    @Transactional
    public ResponseArticleDTO addArticle(RequestArticleDTO requestArticleDTO) {
        Article article = new Article(
                requestArticleDTO.authorId(),
                requestArticleDTO.boardId(),
                requestArticleDTO.title(),
                requestArticleDTO.content(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        articleRepository.addArticle(article);
        return ResponseArticleDTO.of(article);
    }

    @Transactional
    public ResponseArticleDTO updateArticle(Long id, RequestArticleDTO requestArticleDTO) {
        Article article = articleRepository.getArticleById(id).orElse(null);
        if (article == null) return null;
        else {
            article.updateArticle(
                    requestArticleDTO.boardId(),
                    requestArticleDTO.title(),
                    requestArticleDTO.content(),
                    LocalDateTime.now()
            );

            articleRepository.updateArticle(id, article);
            return ResponseArticleDTO.of(article);
        }
    }

    @Transactional
    public boolean deleteArticle(Long id) {
        return articleRepository.deleteArticle(id);
    }
}
