package com.alish.blog_spring.controllers;

import com.alish.blog_spring.models.User;
import com.alish.blog_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    UserService userService;

    @GetMapping("edit")
    public String editProfile(
            Model model
    ){
        User user = userService.getCurrentUser();
        model.addAttribute("user",user);
        return "editProfile";
    }

    @PostMapping("edit")
    public String editPost(
            @RequestParam String username,
            @RequestParam String password
    ){
        User user = userService.getCurrentUser();
        if(username!=null && username.length()<4
                && password.length()<5 ){

        }
        return null;
    }


}
