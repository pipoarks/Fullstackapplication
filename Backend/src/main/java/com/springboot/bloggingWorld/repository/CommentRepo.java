package com.springboot.bloggingWorld.repository;

import com.springboot.bloggingWorld.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long > {


    List<Comment> findByPostId(long postId);
}
