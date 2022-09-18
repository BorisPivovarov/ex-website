package ru.boris.ex_website_api.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.boris.ex_website_api.entity.Post;

import ru.boris.ex_website_api.repository.PostRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogPageController {

    User user;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String allBlogs(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }

    @GetMapping("/blog/post")
    public String addPost(Model model) {
        return "postBlog";
    }

    @PostMapping("/blog/post")
    public String postBlog(@RequestParam String title, @RequestParam String topic,
                           @RequestParam String fullText) {
        Post post = new Post();
        post.setCreatedAt(Instant.now());
        post.setFullText(fullText);
        post.setTitle(title);
        post.setTopic(topic);
        post.setUpdatedAt(Instant.now());
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetail(@PathVariable(value = "id") int id, Model model){
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> byId = postRepository.findById(id);
        ArrayList<Post> postById = new ArrayList<>();
        byId.ifPresent(postById::add);
        model.addAttribute("post", postById);
        return "blog-details";
    }

    @GetMapping("blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") int id, Model model){
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> byId = postRepository.findById(id);
        ArrayList<Post> postById = new ArrayList<>();
        byId.ifPresent(postById::add);
        model.addAttribute("post", postById);
        return "blog-edit";
    }

    @PostMapping("blog/{id}/edit")
    public String postBlogUpdate(@PathVariable(value = "id") int id, @RequestParam String title, @RequestParam String topic,
                           @RequestParam String fullText) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setCreatedAt(Instant.now());
        post.setFullText(fullText);
        post.setTitle(title);
        post.setTopic(topic);
        post.setUpdatedAt(Instant.now());
        postRepository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("blog/{id}/remove")
    public String postBlogDelete(@PathVariable(value = "id") int id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }


}
