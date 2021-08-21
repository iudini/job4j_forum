package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.CommentRepository;
import ru.job4j.forum.repository.PostRepository;

import java.util.*;

@Service
public class CommentService {
    private final CommentRepository comments;
    private final PostRepository posts;

    public CommentService(CommentRepository comments, PostRepository posts) {
        this.comments = comments;
        this.posts = posts;
    }

    public void addComment(Comment comment, Long postId) {
        comment.setCreated(GregorianCalendar.getInstance());
        Optional<Post> post = posts.findById(postId);
        post.ifPresent(comment::setPost);
        comments.save(comment);
    }

    public List<Comment> getById(Long id) {
        Optional<Post> post = posts.findById(id);
        if (post.isPresent()) {
            List<Comment> rsl = comments.findAllByPost(post.get());
            return rsl;
        }
        return null;
    }
}
