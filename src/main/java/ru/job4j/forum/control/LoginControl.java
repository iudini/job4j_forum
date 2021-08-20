package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class LoginControl {
    private final UserService service;

    public LoginControl(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                        Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is incorrect !!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        User userFromDB = service.findByName(user.getUsername());
        if (userFromDB == null || userFromDB.getPassword() != user.getPassword()) {
            return "redirect:login?error=true";
        }
        return "redirect:/";
    }
}
