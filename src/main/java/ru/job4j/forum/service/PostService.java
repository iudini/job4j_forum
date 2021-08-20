package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private final AtomicInteger index = new AtomicInteger(1);
    private final Map<Integer, Post> posts = new HashMap<>();

    public PostService() {
        Post post = new Post();
        post.setName("Продаю машину ладу 01.");
        post.setDesc("some description");
        post.setCreated(GregorianCalendar.getInstance());
        posts.put(0, post);
    }

    public Collection<Post> getAll() {
        return posts.values();
    }

    public Post getById(int id) {
        return posts.get(id);
    }

    public void save(Post post) {
        post.setId(index.getAndIncrement());
        post.setCreated(GregorianCalendar.getInstance());
        posts.put(post.getId(), post);
    }

    public void update(Post post) {
        post.setCreated(posts.get(post.getId()).getCreated());
        posts.put(post.getId(), post);
    }
}