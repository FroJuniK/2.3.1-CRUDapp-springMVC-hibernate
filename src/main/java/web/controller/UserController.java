package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/add")
    public String addUserForm() {
        return "user-form";
    }

    @PostMapping(value = "/add")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        service.addUser(new User(name, lastName, email, password));
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String editUserForm(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("user", service.getUserById(id));
        return "user-form";
    }

    @PostMapping(value = "/edit")
    public String editUser(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        service.editUser(new User(id, name, lastName, email, password));
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        service.deleteUser(id);
        return "redirect:/";
    }
}
