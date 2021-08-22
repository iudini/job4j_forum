package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService posts;
    private final CommentService comments;

    public PostControl(PostService posts, CommentService comments) {
        this.posts = posts;
        this.comments = comments;
    }

    @GetMapping("/post")
    public String post(@RequestParam("id") Long id, Model model) {
        model.addAttribute("post", posts.getById(id));
        model.addAttribute("comments", comments.getById(id));
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post";
    }
}
