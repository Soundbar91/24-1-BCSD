package com.soundbar91.springJDBC.Board.dto;

import com.soundbar91.springJDBC.Board.entity.Board;

public record ResponseBoardDTO(
        String title
) {
    public static ResponseBoardDTO of(Board board) {
        return new ResponseBoardDTO(
                board.getName()
        );
    }
}
