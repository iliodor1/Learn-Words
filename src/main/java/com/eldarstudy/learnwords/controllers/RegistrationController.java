package com.eldarstudy.learnwords.controllers;

import com.eldarstudy.learnwords.models.RegistrationForm;
import com.eldarstudy.learnwords.models.User;
import com.eldarstudy.learnwords.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm() {
        return "registration";
    }
    @PostMapping
    public String processRegistration(RegistrationForm form) {
        User user = userRepo.save(form.toUser(passwordEncoder));
        log.info("User '{}' registered", user.getUsername());
        return "redirect:/login";
    }
}
