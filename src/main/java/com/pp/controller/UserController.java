package com.pp.controller;

import com.pp.model.User;
import com.pp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userServiceImpl;

    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String showAllUser(ModelMap modelMap) {
        List<User> allUsers = userServiceImpl.getAllUsers();
        modelMap.addAttribute("users", allUsers);
        return "user/users";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping("/new")
    public String addPerson(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/";
    }

    @PatchMapping("/update")
    public String create(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/";
    }


    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable("id") long id) {
        userServiceImpl.remove(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") long id) {
        User user = userServiceImpl.find(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

}
