package com.blog_ahmed.blog.controllers;

import com.blog_ahmed.blog.models.Post;
import com.blog_ahmed.blog.repo.PostRepository;
import com.blog_ahmed.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BlogController {

    private final PostRepository postRepository;

    private final PostService postService;

    public BlogController(PostRepository postRepository,
                          PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;
    }


    @GetMapping("/blog")
    public String BlogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
    @GetMapping("/blog/add")
    public String BlogAdd(){
        return "blog-add";
    }
    @PostMapping("/blog/add")
    public String BlodPostAdd(Post model){
        postRepository.save(model);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String BlogDetails(@PathVariable(value = "id") long id, Model model){
        if (!postRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        Post ourPost = post.get();
        model.addAttribute("post", ourPost);
        return "blog-details";
    }
}
