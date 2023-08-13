package com.springboot.bloggingWorld.service;

import com.springboot.bloggingWorld.Exception.ResourceNotFoundException;
import com.springboot.bloggingWorld.entity.Post;
import com.springboot.bloggingWorld.payload.PostDto;
import com.springboot.bloggingWorld.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService{

    private PostRepo postRepository;

    public PostServiceImpl(PostRepo postRepository ){
        this.postRepository=postRepository;
    }


    @Override
    public PostDto createPost(PostDto postDto) {
//Convert DTO to Post
        Post post = mapToEntity(postDto);

       Post newPost = postRepository.save(post);

//Convert entity to dto

        PostDto postResponse = maptoDTO(newPost);


        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() {
        
        
        List<Post> list= (List<Post>) postRepository.findAll();

        List<PostDto> list2= list.stream().map(e->maptoDTO(e)).collect(Collectors.toList());

        return list2;
    }

    @Override
    public PostDto getPostById(long id) {

        Post post= postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));

    PostDto postDto=maptoDTO(post);
        return postDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {


        Post post= postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post newPost = postRepository.save(post);

        return maptoDTO(newPost);
    }

    @Override
    public PostDto deletePost(long id) {

        Post post= postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));
        postRepository.deleteById(id);

        return maptoDTO(post);
    }


    //Convert post to DTO
    private PostDto maptoDTO(Post post){

        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());

        return postDto;

    }

    //Conver DTO to entity

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}
