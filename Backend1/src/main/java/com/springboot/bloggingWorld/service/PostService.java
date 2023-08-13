package com.springboot.bloggingWorld.service;

import com.springboot.bloggingWorld.payload.PostDto;

import java.util.List;

public interface PostService {

     PostDto createPost(PostDto postDto);

     List<PostDto> getAllPost();

     PostDto getPostById(long id);


     PostDto updatePost(  PostDto postDto, long id );

     PostDto deletePost( long id );

}
