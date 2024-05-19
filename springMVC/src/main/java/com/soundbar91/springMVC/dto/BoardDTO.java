package com.soundbar91.springMVC.dto;

public class BoardDTO {
    private String name;

    private BoardDTO() {
    }

    public BoardDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
