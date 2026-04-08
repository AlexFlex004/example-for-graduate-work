package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/set_password")
    public void setPassword(@RequestBody NewPassword request) {
        userService.setPassword(request);
    }

    @GetMapping("/me")
    public User getUser() {
        return userService.getCurrentUser();
    }

    @PatchMapping("/me")
    public UpdateUser updateUser(@RequestBody UpdateUser request) {
        return userService.updateUserProfile(request);
    }

    @PatchMapping("/me/image")
    public void updateUserImage() {
        userService.updateUserImage();
    }
}

