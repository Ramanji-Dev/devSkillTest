package com.example.demo.bean;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    // Constructors
    public Comment() {}

    public Comment( String author, String content, LocalDateTime creationDate) {
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
    public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	// Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
