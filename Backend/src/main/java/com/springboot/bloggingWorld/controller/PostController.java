package com.springboot.bloggingWorld.controller;

import com.springboot.bloggingWorld.entity.Post;
import com.springboot.bloggingWorld.payload.PostDto;
import com.springboot.bloggingWorld.repository.PostRepo;
import com.springboot.bloggingWorld.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/")
public class PostController {
    @Autowired
     private PostService postService;

    @GetMapping("hello")
    public String hi(){
        return "Working APi";
    }

    @GetMapping("AllPosts")
    public ResponseEntity<List<PostDto>>  AllPost(){

        //ResponseEntity<List<PostDto>> ResponseEntity= new ResponseEntity<>();

        List<PostDto> list =  postService.getAllPost();

        ResponseEntity<List<PostDto>> ResponseEntity= new ResponseEntity<>(list,HttpStatus.OK);
        return ResponseEntity;
    }

    @PostMapping("createPost")
    public ResponseEntity<PostDto>  createPost(@RequestBody PostDto postDto){


        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable (name="id") long id)
    {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto ,@PathVariable (value="id") long id  ){

        PostDto p=postService.updatePost(postDto , id);

        ResponseEntity<PostDto> responseEntity= new ResponseEntity<>(p,HttpStatus.OK);

        return responseEntity;

    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<PostDto> deletePost(@PathVariable(value="id") long id){

        ResponseEntity<PostDto> rsponse = new ResponseEntity<>(postService.deletePost(id),HttpStatus.OK);

        return rsponse;

    }


}
