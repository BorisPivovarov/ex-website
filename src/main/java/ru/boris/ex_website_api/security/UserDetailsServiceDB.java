package ru.boris.ex_website_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.boris.ex_website_api.entity.User;
import ru.boris.ex_website_api.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class UserDetailsServiceDB implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDetailsDb(user);
    }

//    @Autowired
//    PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void init() {
//        User user = new User();
//        user.setLogin("admin");
//        user.setPassword(passwordEncoder.encode("12345"));
//        user.setActivatedAt(Instant.now());
//        userRepository.save(user);
//    }
}
