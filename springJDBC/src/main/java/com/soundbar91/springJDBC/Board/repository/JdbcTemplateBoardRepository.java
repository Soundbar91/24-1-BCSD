package com.soundbar91.springJDBC.Board.repository;

import com.soundbar91.springJDBC.Board.entity.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class JdbcTemplateBoardRepository implements BoardRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final AtomicLong autoincrement = new AtomicLong(1);

    public JdbcTemplateBoardRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addBoard(Board board) {
        String sql = "insert into board (id, name) values (?, ?)";
        board.setId(autoincrement.getAndIncrement());
        jdbcTemplate.update(sql, board.getId(), board.getName());
    }

    @Override
    public Optional<Board> getBoardById(Long id) {
        String sql = "select id, name from board where id = ?";
        List<Board> result = jdbcTemplate.query(sql, boardRowMapper, id);
        return result.stream().findFirst();
    }

    @Override
    public void updateBoard(Long id, Board board) {
        String sql = "update board set name = ? where id = ?";
        jdbcTemplate.update(sql, board.getName(), id);
    }

    @Override
    public boolean deleteBoard(Long id) {
        String sql = "delete from board where id = ?";
        return jdbcTemplate.update(sql, id) == 1;
    }

    private final RowMapper<Board> boardRowMapper = (resultSet, rowNum) -> {
        Board board = new Board(resultSet.getString("name"));
        board.setId(resultSet.getLong("id"));
        return board;
    };
}
