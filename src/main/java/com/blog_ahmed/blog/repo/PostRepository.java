package com.blog_ahmed.blog.repo;

import com.blog_ahmed.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
