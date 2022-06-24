package ru.ioga.KataPP311SpringBootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ioga.KataPP311SpringBootCRUD.model.User;
import ru.ioga.KataPP311SpringBootCRUD.service.UserService;

import java.util.List;

/**
 * @author shokhalevich
 */

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping(value = "/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping(value = "/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        System.out.println("IDIDIDIDIDI" + id);
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        System.out.println(user);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PatchMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

}
