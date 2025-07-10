package com.example.demo.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.demo.bean.Comment;
import com.example.demo.bean.Post;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.NewCommentDto;
import com.example.demo.repo.CommentRepository;
import com.example.demo.repo.PostRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> getCommentsForPost(Integer postId) {
    	return postRepository.findById(postId)
    		    .<List<CommentDto>>map(post -> commentRepository.findByPost(post).stream()
    		        .map(comment -> new CommentDto(
    		            comment.getId(),
    		            comment.getAuthor(),
    		            comment.getContent(),
    		            comment.getCreationDate()))
    		        .collect(Collectors.toList()))
    		    .orElse(Collections.emptyList());
    }

    public void addComment(Integer postId, NewCommentDto newCommentDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postId));

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setAuthor(newCommentDto.getAuthor());
        comment.setContent(newCommentDto.getComment());
        comment.setCreationDate(LocalDateTime.now());

        commentRepository.save(comment); // ✅ Save entity, not DTO
    }
}












