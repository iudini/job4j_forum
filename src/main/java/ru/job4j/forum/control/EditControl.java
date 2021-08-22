package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class EditControl {
    private final PostService service;
    private final UserService users;

    public EditControl(PostService service, UserService users) {
        this.service = service;
        this.users = users;
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        return "edit";
    }

    @PostMapping("/create")
    public String create(Post post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        post.setUser(user);
        service.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") String id, Model model) {
        Post post = service.getById(Long.parseLong(id));
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Post post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        post.setUser(user);
        service.update(post);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
