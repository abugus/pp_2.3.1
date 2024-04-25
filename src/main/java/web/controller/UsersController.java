package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("listOfUsers", userService.show());
        return "showUsers";
    }

    @GetMapping("/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/show")
    public String showUser(Model model, @RequestParam("id") int id) {
        model.addAttribute("showUser", userService.index(id));
        return "showUser";
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/editForm")
    public String updateUser(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.index(id));
        return "editUser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.remove(id);
        return "redirect:/users";
    }

}
