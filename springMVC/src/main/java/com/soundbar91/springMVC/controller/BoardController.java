package com.soundbar91.springMVC.controller;

import com.soundbar91.springMVC.dto.BoardDTO;
import com.soundbar91.springMVC.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController() {
        this.boardService = new BoardService();
    }

    @PostMapping
    public ResponseEntity<Void> createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.addBoard(boardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
