package com.soundbar91.springJDBC.Board.controller;

import com.soundbar91.springJDBC.Board.dto.RequestBoardDTO;
import com.soundbar91.springJDBC.Board.dto.ResponseBoardDTO;
import com.soundbar91.springJDBC.Board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(DataSource dataSource) {
        this.boardService = new BoardService(dataSource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBoardDTO> getBoardById(@PathVariable("id") Long id) {
        ResponseBoardDTO board = boardService.getBoardById(id);
        return board != null ? ResponseEntity.ok(board) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ResponseBoardDTO> createBoard(@RequestBody RequestBoardDTO board) {
        ResponseBoardDTO responseBoardDTO = boardService.addBoard(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBoardDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBoardDTO> updateBoard(@PathVariable("id") Long id, @RequestBody RequestBoardDTO board) {
        ResponseBoardDTO responseBoardDTO = boardService.updateBoard(id, board);
        return responseBoardDTO != null ? ResponseEntity.ok(responseBoardDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBoardDTO> deleteBoard(@PathVariable("id") Long id) {
        return boardService.deleteBoard(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
