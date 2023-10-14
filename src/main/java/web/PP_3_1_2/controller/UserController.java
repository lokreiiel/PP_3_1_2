package web.PP_3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.PP_3_1_2.model.User;
import web.PP_3_1_2.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUser(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "all";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "save";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }


    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }


}