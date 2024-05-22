package com.soundbar91.springMVC.service;

import com.soundbar91.springMVC.dto.RequestArticleDTO;
import com.soundbar91.springMVC.dto.ResponseArticleDTO;
import com.soundbar91.springMVC.entity.Article;
import com.soundbar91.springMVC.repository.*;

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

        String writer = memberRepository.getMemberById(articleById.getAuthorId()).getName();
        return new ResponseArticleDTO(articleById, writer);
    }

    public List<ResponseArticleDTO> getArticles() {
        List<ResponseArticleDTO> responseArticleDTOList = new ArrayList<>();
        List<Article> allArticles = articleRepository.getAllArticles();

        for (Article article : allArticles) {
            String writer = memberRepository.getMemberById(article.getAuthorId()).getName();
            responseArticleDTOList.add(new ResponseArticleDTO(article, writer));
        }

        return responseArticleDTOList;
    }

    public Map<String, List<ResponseArticleDTO>> getArticlesWithBoard() {
        Map<String, List<ResponseArticleDTO>> responseArticleDTOMap = new HashMap<>();
        List<Article> allArticles = articleRepository.getAllArticles();

        for (Article article : allArticles) {
            String writer = memberRepository.getMemberById(article.getAuthorId()).getName();
            ResponseArticleDTO responseArticleDTO = new ResponseArticleDTO(article, writer);

            String boardName = boardRepository.getBoard(article.getBoardId()).getTitle();

            if (!responseArticleDTOMap.containsKey(boardName)) responseArticleDTOMap.put(boardName, new ArrayList<>());
            responseArticleDTOMap.get(boardName).add(responseArticleDTO);
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

        articleById.updateArticle(articleDTO.getTitle(), articleDTO.getContent());
        return articleRepository.updateArticle(articleById);
    }

    public boolean deleteArticle(Long id) {
        return articleRepository.deleteArticle(id);
    }
}
