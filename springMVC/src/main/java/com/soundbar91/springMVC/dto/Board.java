package com.soundbar91.springMVC.dto;

public class Board {
    private long boardId;
    private String boardName;

    public Board(long boardId, String boardName) {
        this.boardId = boardId;
        this.boardName = boardName;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
