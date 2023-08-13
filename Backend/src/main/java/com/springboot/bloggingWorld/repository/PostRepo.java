package com.springboot.bloggingWorld.repository;

import com.springboot.bloggingWorld.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {


   // public List<Post> getAllPost();
}
