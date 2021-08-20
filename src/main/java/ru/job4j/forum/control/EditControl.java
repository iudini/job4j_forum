package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class EditControl {
    private final PostService service;

    public EditControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String createPage() {
        return "edit";
    }

    @PostMapping("/create")
    public String create(Post post) {
        service.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") String id, Model model) {
        Post post = service.getById(Integer.parseInt(id));
        model.addAttribute("post", post);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Post post) {
        service.update(post);
        return "redirect:/";
    }
}
