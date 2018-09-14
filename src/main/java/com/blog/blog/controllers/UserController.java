package com.blog.blog.controllers;

import com.blog.blog.models.User;
import com.blog.blog.reposititories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private PasswordEncoder passwordEncoder;

    UserRepository userDao;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

   @GetMapping("/signup")
       public String showSignupForm(Model model){
           model.addAttribute("newUser", new User());
           return "users/signup";
       }

       @PostMapping("/signup")
       public String saveUser(@ModelAttribute User user) {
           String hash = passwordEncoder.encode(user.getPassword());
           user.setPassword(hash);
           userDao.save(user);
           return "redirect:/login";
       }
   

//    @GetMapping("/login")
//    public String loginUser(){
//        return "users/login";
//    }

//    @PostMapping("/login")
//    public String userAuth(@RequestParam("username") String username, @RequestParam("password") String password){
//        User testUser = userDao.findByUsername(username);
//        if(testUser.getPassword().equals(password)){
//            return "redirect:/";
//        }
//
//        return "users/login";
//    }

    @GetMapping("/mypage")
    public String userProfile(Model model){
        User pageUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", pageUser);
        return "users/profile";
    }

}
