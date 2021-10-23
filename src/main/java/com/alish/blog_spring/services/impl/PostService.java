package com.alish.blog_spring.services.impl;

import com.alish.blog_spring.models.Post;
import com.alish.blog_spring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getPostById(Long id){
        return  postRepository.findById(id).get();
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post addPost(Post post){
        return postRepository.save(post);
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }


}
