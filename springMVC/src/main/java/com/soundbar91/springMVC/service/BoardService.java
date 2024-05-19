package com.soundbar91.springMVC.service;

import com.soundbar91.springMVC.dto.BoardDTO;
import com.soundbar91.springMVC.entity.Board;
import com.soundbar91.springMVC.repository.BoardRepository;
import com.soundbar91.springMVC.repository.MemoryBoardRepository;

public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService() {
        this.boardRepository = new MemoryBoardRepository();
    }

    public void addBoard(BoardDTO boardDTO) {
        boardRepository.addBoard(new Board(boardDTO.getName()));
    }
}
