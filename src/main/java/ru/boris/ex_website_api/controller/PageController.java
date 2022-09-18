package ru.boris.ex_website_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to main page");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Page about Boris Pivovarov");
        return "about";
    }

    @GetMapping("/auth")
    public String auth(Model model) {
        model.addAttribute("title", "Welcome to auth page");
        return "home";
    }
}
