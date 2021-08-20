package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.service.CommentService;

@Controller
public class CommentControl {
    private final CommentService service;

    public CommentControl(CommentService service) {
        this.service = service;
    }

    @PostMapping("/add_comment")
    public String addComment(@RequestParam("id") int id, Comment comment) {
        service.addComment(comment, id);
        return "redirect:/post?id=" + id;
    }
}
