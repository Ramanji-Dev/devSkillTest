package com.example.demo.dto;

import java.time.LocalDateTime;

public class CommentDto {
	private String id;
    private String author;
    private String content;
    private LocalDateTime creationDate;

    public CommentDto(String id, String author, String content, LocalDateTime creationDate) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
    }
}
