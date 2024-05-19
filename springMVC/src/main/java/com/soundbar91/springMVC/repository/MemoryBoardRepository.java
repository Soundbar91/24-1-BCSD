package com.soundbar91.springMVC.repository;

import com.soundbar91.springMVC.entity.Board;

import java.util.HashMap;
import java.util.Map;

public class MemoryBoardRepository implements BoardRepository {

    private final static Map<Long, Board> boards = new HashMap<>();
    private long currentId = 0;

    @Override
    public void addBoard(Board board) {
        board.setId(currentId);
        boards.put(currentId++, board);
    }

    @Override
    public Board getBoard(Long id) {
        return boards.get(id);
    }
}
