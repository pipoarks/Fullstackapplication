package com.springboot.bloggingWorld.service;

import com.springboot.bloggingWorld.Exception.ResourceNotFoundException;
import com.springboot.bloggingWorld.entity.Comment;
import com.springboot.bloggingWorld.entity.Post;
import com.springboot.bloggingWorld.payload.CommentDto;
import com.springboot.bloggingWorld.repository.CommentRepo;
import com.springboot.bloggingWorld.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepo commentRepository;

     private PostRepo postRepository;


    public CommentServiceImpl(CommentRepo commentRepository,PostRepo postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public CommentDto createComment(CommentDto commentDto , long postId) {

       Comment comment=mapToEntity(commentDto);
        Post post= postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));


        comment.setPost(post);
        Comment newComment =commentRepository.save(comment);

        return maptoDTO( newComment );
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {

  List<Comment> list = commentRepository.findByPostId(postId);

         return list.stream().map(e->maptoDTO(e)).collect(Collectors.toList());


    }


    private CommentDto maptoDTO(Comment comment){

        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());

        return commentDto;

    }

    //Conver DTO to entity

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment  = new Comment();

        comment.setId(commentDto.getId());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());

        return comment;
    }
}
