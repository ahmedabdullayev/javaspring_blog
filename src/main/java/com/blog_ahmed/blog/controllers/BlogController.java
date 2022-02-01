package com.blog_ahmed.blog.controllers;

import com.blog_ahmed.blog.models.Post;
import com.blog_ahmed.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    private final PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/blog")
    public String BlogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

}
