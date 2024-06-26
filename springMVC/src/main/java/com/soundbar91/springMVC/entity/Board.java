package com.soundbar91.springMVC.entity;

public class Board {
    private Long id;
    private String title;

    public Board(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void updateBoard(String title) {
        this.title = title;
    }
}
