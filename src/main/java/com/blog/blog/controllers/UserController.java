package com.blog.blog.controllers;

import com.blog.blog.models.User;
import com.blog.blog.reposititories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/signup")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "users/signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) {
        try {
            userDao.save(user);
            return "redirect:users/login";
        } catch (Exception e) {
            throw new RuntimeException("Error at Signup");
        }

    }
    @GetMapping("/login")
    public String loginUser(){
        return "users/login";
    }

    @PostMapping("/login")
    public String userAuth(@RequestParam("username") String username, @RequestParam("password") String password){
        List<User> users = userDao.findAll();

        for(User user: users){
            if (user.getUsername().equals(username)){
                if(user.getPassword().equals(password) ){
                    return "users/"+username;
                }
            }
        }
        return "users/login";
    }

    @GetMapping("/{username}")
    public String userProfile(@PathVariable("username") String username, Model model){
        User pageUser = userDao.findByUsername(username);
        model.addAttribute("user", pageUser);
        return "users/profile";
    }

}
