package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Comment;
import com.example.demo.bean.Post;

public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findByPost(Post post);
}