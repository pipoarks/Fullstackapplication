package com.springboot.bloggingWorld.service;

import com.springboot.bloggingWorld.entity.Comment;
import com.springboot.bloggingWorld.payload.CommentDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {





    CommentDto createComment(CommentDto commentDto,long postId);

    List<CommentDto> getCommentsByPostId(long postId);
}
