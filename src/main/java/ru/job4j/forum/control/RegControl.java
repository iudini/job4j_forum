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
public class RegControl {
    private final UserService service;

    public RegControl(UserService service) {
        this.service = service;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        if (service.findByName(user.getUsername()) != null) {
            return "redirect:reg?error=true";
        }
        service.save(user);
        return "redirect:login";
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(value = "error", required = false) String error,
                      Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Current username is exist";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "reg";
    }
}
