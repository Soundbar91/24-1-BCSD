package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.entity.Board;

public interface BoardRepository {

    void addBoard(Board board);
    Board getBoard(Long id);
}
