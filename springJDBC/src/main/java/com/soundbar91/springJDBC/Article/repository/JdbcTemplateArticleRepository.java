package com.soundbar91.springJDBC.Article.repository;

import com.soundbar91.springJDBC.Article.entity.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class JdbcTemplateArticleRepository implements ArticleRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final AtomicLong autoincrement = new AtomicLong(1);

    public JdbcTemplateArticleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Article> getArticleById(Long id) {
        String sql = "SELECT id, author_id, board_id, title, content, created_date, modified_date FROM article WHERE id = ?";
        List<Article> result = jdbcTemplate.query(sql, articleRowMapper, id);
        return result.stream().findFirst();
    }

    @Override
    public List<Article> getArticlesByBoard(Long boardId) {
        String sql = "SELECT id, author_id, board_id, title, content, created_date, modified_date FROM article WHERE board_id = ?";
        return jdbcTemplate.query(sql, articleRowMapper, boardId);
    }

    @Override
    public void addArticle(Article article) {
        String sql = "INSERT INTO ARTICLE (id, author_id, board_id, title, content, created_date, modified_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        article.setId(autoincrement.getAndIncrement());
        jdbcTemplate.update(sql, article.getId(), article.getAuthor_id(),
                article.getBoard_id(), article.getTitle(), article.getContent(), article.getCreated_data(), article.getModified_data());
    }

    @Override
    public void updateArticle(Long id, Article updatedArticle) {
        String sql = "UPDATE article SET board_id = ?, title = ?, content = ?, modified_date = ? WHERE id = ?";
        jdbcTemplate.update(sql, updatedArticle.getBoard_id(), updatedArticle.getTitle(), updatedArticle.getContent(), updatedArticle.getModified_data(), id);
    }

    @Override
    public boolean deleteArticle(Long id) {
        String sql = "DELETE FROM article WHERE id = ?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    private final RowMapper<Article> articleRowMapper = (resultSet, rowNum) -> {
        Article article = new Article(
                resultSet.getLong("author_id"),
                resultSet.getLong("board_id"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getTimestamp("created_date").toLocalDateTime(),
                resultSet.getTimestamp("modified_date").toLocalDateTime()
        );
        article.setId(resultSet.getLong("id"));
        return article;
    };
}
