package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Post;

public interface PostRepository  extends JpaRepository<Post,Integer>{

}
