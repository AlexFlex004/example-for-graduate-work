package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.Login;
import ru.skypro.homework.dto.Register;

@RestController
public class AuthController {

    @PostMapping("/register")
    public void register(@RequestBody Register request) {
    }

    @PostMapping("/login")
    public void login(@RequestBody Login request) {
    }
}
