package ru.boris.ex_website_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.boris.ex_website_api.entity.RegDto;
import ru.boris.ex_website_api.entity.User;
import ru.boris.ex_website_api.repository.UserRepository;

import java.time.Instant;

@RequestMapping("/registration")
@Controller
public class RegController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/open")
    public String openRegPage(Model model) {
        RegDto regDto = new RegDto();
        model.addAttribute("dto", regDto);
        return "registration";
    }

    @PostMapping("/register")
    public String postUser(RegDto regDto) {
        if (!regDto.getConfirm().equals(regDto.getPassword())) {
            throw new RuntimeException("Password is not correct");
        }
        if (userRepository.existsByLogin(regDto.getLogin())) {
            throw new RuntimeException("Login is exists");
        }
        User user = new User();
        user.setLogin(regDto.getLogin());
        user.setPassword(passwordEncoder.encode(regDto.getPassword()));
        user.setActivatedAt(Instant.now());
        userRepository.save(user);
        return "redirect:/auth";
    }
}
