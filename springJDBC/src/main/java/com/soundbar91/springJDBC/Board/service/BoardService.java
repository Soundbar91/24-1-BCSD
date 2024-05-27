package com.soundbar91.springJDBC.Board.service;

import com.soundbar91.springJDBC.Board.dto.RequestBoardDTO;
import com.soundbar91.springJDBC.Board.dto.ResponseBoardDTO;
import com.soundbar91.springJDBC.Board.entity.Board;
import com.soundbar91.springJDBC.Board.repository.BoardRepository;
import com.soundbar91.springJDBC.Board.repository.JdbcTemplateBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(DataSource dataSource) {
        this.boardRepository = new JdbcTemplateBoardRepository(dataSource);
    }

    @Transactional(readOnly = true)
    public ResponseBoardDTO getBoardById(Long id) {
        return boardRepository.getBoardById(id)
                .map(ResponseBoardDTO::of)
                .orElse(null);
    }

    @Transactional
    public ResponseBoardDTO addBoard(RequestBoardDTO boardDTO) {
        Board board = new Board(boardDTO.title());

        boardRepository.addBoard(board);
        return ResponseBoardDTO.of(board);
    }

    @Transactional
    public ResponseBoardDTO updateBoard(Long id, RequestBoardDTO boardDTO) {
        Board board = boardRepository.getBoardById(id).orElse(null);
        if (board == null) return null;

        board.updateBoard(boardDTO.title());
        boardRepository.updateBoard(id, board);
        return ResponseBoardDTO.of(board);
    }

    @Transactional
    public boolean deleteBoard(Long id) {
        return boardRepository.deleteBoard(id);
    }
}
