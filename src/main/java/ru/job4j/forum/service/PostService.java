package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public Collection<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post getById(Long id) {
        return posts.findById(id).orElse(null);
    }

    public void save(Post post) {
        post.setCreated(GregorianCalendar.getInstance());
        posts.save(post);
    }

    public void update(Post post) {
        post.setCreated(posts.findById(post.getId()).get().getCreated());
        posts.save(post);
    }

    public void deleteById(Long id) {
        posts.deleteById(id);
    }
}