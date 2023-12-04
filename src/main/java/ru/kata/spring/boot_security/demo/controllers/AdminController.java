package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UsersService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsersService usersService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UsersService usersService, RoleService roleService) {
        this.usersService = usersService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getUsers(@ModelAttribute("user") User user, Model model,
                           Principal principal) {

        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("usingUser", usersService.getUserByUsername(principal.getName()));
        return "admin";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {

        usersService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", usersService.findOne(id));
        return "redirect:/admin";
    }

    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {

        usersService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        usersService.delete(id);
        return "redirect:/admin";
    }
}