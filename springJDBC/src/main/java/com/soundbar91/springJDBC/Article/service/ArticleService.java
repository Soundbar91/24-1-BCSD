package com.soundbar91.springJDBC.Article.service;

import com.soundbar91.springJDBC.Article.dto.RequestArticleDTO;
import com.soundbar91.springJDBC.Article.dto.ResponseArticleDTO;
import com.soundbar91.springJDBC.Article.entity.Article;
import com.soundbar91.springJDBC.Article.repository.ArticleRepository;
import com.soundbar91.springJDBC.Article.repository.JdbcTemplateArticleRepository;
import com.soundbar91.springJDBC.Board.entity.Board;
import com.soundbar91.springJDBC.Board.repository.BoardRepository;
import com.soundbar91.springJDBC.Board.repository.JdbcTemplateBoardRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;

    public ArticleService(DataSource dataSource) {
        this.articleRepository = new JdbcTemplateArticleRepository(dataSource);
        this.boardRepository = new JdbcTemplateBoardRepository(dataSource);
    }

    public Map<String, List<ResponseArticleDTO>> getArticleByBoardId(Long boardId) {
        String boardName = boardRepository.getBoardById(boardId)
                .map(Board::getName)
                .orElse(null);

        if (boardName == null) return null;
        else {
            Map<String, List<ResponseArticleDTO>> result = new HashMap<>();

            List<ResponseArticleDTO> responseArticleDTOList = new ArrayList<>();
            List<Article> articlesByBoard = articleRepository.getArticlesByBoard(boardId);

            for (Article article : articlesByBoard) responseArticleDTOList.add(ResponseArticleDTO.of(article));

            result.put(boardName, responseArticleDTOList);
            return result;
        }
    }

    public ResponseArticleDTO getArticleById(Long articleId) {
        return articleRepository.getArticleById(articleId)
                .map(ResponseArticleDTO::of)
                .orElse(null);
    }

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

    public boolean deleteArticle(Long id) {
        return articleRepository.deleteArticle(id);
    }
}
