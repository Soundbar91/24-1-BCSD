package com.soundbar91.springJDBC.Board.entity;

public class Board {
    private Long id;
    private String name;

    public Board(String title) {
        this.name = title;
    }

    public void updateBoard(String title) {
        this.name = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
