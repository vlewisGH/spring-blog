package com.blog.blog.reposititories;

import com.blog.blog.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByUsername(String user);
}
