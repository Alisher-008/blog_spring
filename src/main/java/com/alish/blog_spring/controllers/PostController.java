package com.alish.blog_spring.controllers;

import com.alish.blog_spring.models.Post;
import com.alish.blog_spring.models.User;
import com.alish.blog_spring.services.impl.PostService;
import com.alish.blog_spring.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public String posts(){
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String posts(
            Model model
    ){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posty", posts);
        return "posts";
    }

    @GetMapping("/posts/new")
    public String newPost(
            Model model
    ){
        return "newPost";
    }

    @PostMapping("/posts/new")
    public String newPost(
            @RequestParam String title,
            @RequestParam String content
    ){
        User user = userServiceImpl.getCurrentUser();
        if(user == null) {
            throw new IllegalArgumentException();
        }
        Post post = new Post(null, title, content, new Timestamp(System.currentTimeMillis()), null,user);
        post = postService.addPost(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/edit/{post_id}")
    public String editPost(
            @PathVariable(name = "post_id") Long postId,
            Model model
    ){
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);

        List<User> authors = userServiceImpl.getAllUsers();
        model.addAttribute("authors", authors);

        return "editPost";
    }

    @PostMapping("/posts/edit")
    public String editPost(
            @RequestParam(name = "id") Long postId,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam(name = "new_author_id") Long newAuthorId
    ){
        User newAuthor = userServiceImpl.getUserById(newAuthorId);
        if(newAuthor == null) {
            throw new IllegalArgumentException();
        }
        Post post = postService.getPostById(postId);
        post.setContent(content);
        post.setTitle(title);
        post.setAuthor(newAuthor);
        post.setEditDate(new Timestamp(System.currentTimeMillis()));
        postService.savePost(post);
        return "redirect:/posts/" + postId;
    }

    @GetMapping("/posts/{postId}")
    public String postById(
            Model model,
            @PathVariable Long postId
    ){
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "postDetails";
    }
}