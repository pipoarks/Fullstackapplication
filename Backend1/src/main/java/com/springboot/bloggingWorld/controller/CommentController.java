package com.springboot.bloggingWorld.controller;


import com.springboot.bloggingWorld.entity.Comment;

import com.springboot.bloggingWorld.payload.CommentDto;
import com.springboot.bloggingWorld.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class CommentController {


    @Autowired
    private CommentService commentService;




    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value="postId") long postId, @RequestBody CommentDto commentDto) {


        CommentDto newCommentDto = commentService.createComment(commentDto , postId);

    ResponseEntity<CommentDto> response = new ResponseEntity<>(newCommentDto , HttpStatus.CREATED  );

    return response;
    }


    @GetMapping("/post/{postId}/comments")
    public List<CommentDto> getCommentByPost(@PathVariable(value="postId") long postId ){



        return commentService.getCommentsByPostId(postId);

}


}
