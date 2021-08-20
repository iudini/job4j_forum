package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;

import java.util.*;

@Service
public class CommentService {
    private final Map<Integer, List<Comment>> comments = new HashMap<>();

    public CommentService() {
        Comment comment = new Comment();
        comment.setDesc("Description");
        comment.setAuthor("Author");
        comment.setCreated(GregorianCalendar.getInstance());
        addComment(comment, 0);
    }

    public void addComment(Comment comment, int id) {
        comment.setCreated(GregorianCalendar.getInstance());
        comments.putIfAbsent(id, new ArrayList<>());
        comments.get(id).add(comment);
    }

    public List<Comment> getById(int id) {
        return comments.get(id);
    }
}
