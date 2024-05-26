package com.soundbar91.springJDBC.Board.repository;

import com.soundbar91.springJDBC.Board.entity.Board;

import java.util.Optional;

public interface BoardRepository {

    void addBoard(Board board);
    Optional<Board> getBoardById(Long id);
    void updateBoard(Long id, Board board);
    boolean deleteBoard(Long id);
}
