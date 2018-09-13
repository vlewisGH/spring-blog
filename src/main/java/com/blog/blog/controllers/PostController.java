package com.blog.blog.controllers;

import com.blog.blog.Services.PostService;
import com.blog.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.List;

@Controller
public class PostController {


    private PostService postSvc;

    public PostController(PostService postService) {
        this.postSvc = postService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model indexModel) {
        List<Post> allPosts = postSvc.getAll();
        List<Post> shallowCopy = allPosts.subList(0, allPosts.size());
        Collections.reverse(shallowCopy);
        indexModel.addAttribute("posts", shallowCopy);
        return "posts/index";
    }
//
    @GetMapping("/posts/{id}")
    public String postShow(@PathVariable int id, Model showModel) {
        showModel.addAttribute("post", postSvc.getPostById(id));
        return "posts/show" ;
    }
//
    @GetMapping("/posts/create")
    public String postsNew(Model model) {
        model.addAttribute("post", new Post());
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public RedirectView postsCreate(@ModelAttribute Post post) {
        postSvc.addPost(post);
        return new RedirectView( "/posts");
    }

    @GetMapping("/posts/delete/{id}")
    public RedirectView deletePost(@PathVariable(name = "id") long id) {
        postSvc.removePostById(id);
        return new RedirectView( "/posts");
    }
}
