package com.blog_ahmed.blog.services;

import com.blog_ahmed.blog.models.Post;
import com.blog_ahmed.blog.repo.PostRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public long addViews(long id){
        Post post = postRepository.findById(id).orElseThrow();
        post.increaseViews();
        postRepository.save(post);
        return id;
    }
}
