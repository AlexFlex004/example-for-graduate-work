package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.User;

@RestController
@RequestMapping("/users")
public class UsersController {

    @PostMapping("/set_password")
    public void setPassword(@RequestBody NewPassword request) {
    }

    @GetMapping("/me")
    public User getUser() {
        return new User();
    }

    @PatchMapping("/me")
    public UpdateUser updateUser(@RequestBody UpdateUser request) {
        return new UpdateUser();
    }

    @PatchMapping("/me/image")
    public void updateUserImage() {
    }
}
