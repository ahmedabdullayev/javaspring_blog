package com.blog_ahmed.blog.services;

import com.blog_ahmed.blog.repo.PostRepository;
import org.springframework.stereotype.Component;

@Component
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


}
