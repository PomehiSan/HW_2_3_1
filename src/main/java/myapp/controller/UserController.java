package myapp.controller;

import myapp.model.User;
import myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(@ModelAttribute(value = "user") User user, ModelMap model) {
        model.put("users", userService.getUsers());
        return "index";
    }

    @PostMapping("/delete={id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/adduser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit={id}")
    public String editUser(@PathVariable(value = "id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
