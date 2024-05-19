package com.soundbar91.springMVC.service;

import com.soundbar91.springMVC.dto.RequestArticleDTO;
import com.soundbar91.springMVC.dto.ResponseArticleDTO;
import com.soundbar91.springMVC.entity.Article;
import com.soundbar91.springMVC.repository.*;

import java.time.LocalDateTime;
import java.util.*;

public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public ArticleService() {
        this.articleRepository = new MemoryArticleRepository();
        this.memberRepository = new MemoryMemberRepository();
        this.boardRepository = new MemoryBoardRepository();
    }

    public ResponseArticleDTO getArticle(Long id) {
        Article articleById = articleRepository.getArticleById(id);
        if (articleById == null) return null;

        return new ResponseArticleDTO(
                articleById.getTitle(),
                articleById.getContent(),
                memberRepository.getMemberById(articleById.getAuthorId()).getName(),
                articleById.getWriteDate()
        );
    }

    public List<ResponseArticleDTO> getArticles() {
        List<ResponseArticleDTO> responseArticleDTOList = new ArrayList<>();
        List<Article> allArticles = articleRepository.getAllArticles();

        for (Article article : allArticles) {
            ResponseArticleDTO responseArticleDTO = new ResponseArticleDTO(
                    article.getTitle(),
                    memberRepository.getMemberById(article.getAuthorId()).getName(),
                    article.getContent(),
                    article.getWriteDate()
            );

            responseArticleDTOList.add(responseArticleDTO);
        }

        return responseArticleDTOList;
    }

    public Map<String, List<ResponseArticleDTO>> getArticlesWithBoard() {
        Map<String, List<ResponseArticleDTO>> responseArticleDTOMap = new HashMap<>();
        List<Article> allArticles = articleRepository.getAllArticles();

        for (Article article : allArticles) {
            ResponseArticleDTO responseArticleDTO = new ResponseArticleDTO(
                    article.getTitle(),
                    memberRepository.getMemberById(article.getAuthorId()).getName(),
                    article.getContent(),
                    article.getWriteDate()
            );

            if (!responseArticleDTOMap.containsKey(boardRepository.getBoard(article.getBoardId()).getTitle()))
                responseArticleDTOMap.put(boardRepository.getBoard(article.getBoardId()).getTitle(), new ArrayList<>());
            responseArticleDTOMap.get(boardRepository.getBoard(article.getBoardId()).getTitle()).add(responseArticleDTO);
        }

        return responseArticleDTOMap;
    }

    public void addArticle(RequestArticleDTO articleDTO) {
        articleRepository.addArticle(new Article(articleDTO.getAuthorId(), articleDTO.getBoardId(),
                articleDTO.getTitle(), articleDTO.getContent()));
    }

    public boolean updateArticle(Long id, RequestArticleDTO articleDTO) {
        Article articleById = articleRepository.getArticleById(id);
        if (articleById == null) return false;

        articleById.setTitle(articleDTO.getTitle());
        articleById.setContent(articleDTO.getContent());
        articleById.setModifiedDate(LocalDateTime.now());

        return articleRepository.updateArticle(articleById);
    }

    public boolean deleteArticle(Long id) {
        return articleRepository.deleteArticle(id);
    }
}
