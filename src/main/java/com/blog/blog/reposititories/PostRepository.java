package com.blog.blog.reposititories;

import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
}
