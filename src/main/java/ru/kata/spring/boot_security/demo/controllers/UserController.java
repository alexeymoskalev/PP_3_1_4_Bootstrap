package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.services.UsersService;

import java.security.Principal;

@Controller
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/user")
    public String getUsers(Model model, Principal principal) {
        model.addAttribute("usingUser", usersService.getUserByUsername(principal.getName()));
        return "user";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
