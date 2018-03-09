package com.kienhv.stories.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kienhv.stories.website.CurrentUser;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home1() {
        return "/home";
    }
    @GetMapping("/register")
    public String register() {
    	return "/register";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin(@CurrentUser UserDetails user) {
        return "/admin";
    }

    @GetMapping("/user")
    public String user(@CurrentUser UserDetails user) {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
    
    @GetMapping("/react")
    public String react() {
        return "/life_stories/public/index";
    }
    
    

}