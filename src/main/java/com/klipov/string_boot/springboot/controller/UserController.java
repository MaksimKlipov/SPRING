package com.klipov.string_boot.springboot.controller;

import com.klipov.string_boot.springboot.model.User;
import com.klipov.string_boot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping("/index")
    public String userPage() {
        return "index";
    }

    @GetMapping("/user")
    public String adminPage() {
        return "user";
    }
}
