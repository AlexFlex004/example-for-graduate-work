package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UpdateUser;
import ru.skypro.homework.dto.user.User;
import ru.skypro.homework.service.UserService;

import javax.validation.Valid;


/**
 * Контроллер для обработки HTTP-запросов, связанных с управлением профилем пользователя.
 * Предоставляет API-методы для получения, обновления информации, изменения пароля и аватара авторизованного пользователя.
 */
@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UsersController {

    private final UserService userService;

    @PostMapping("/set_password")
    public ResponseEntity<Void> changePassword(
            @Valid @RequestBody NewPassword request,
            Authentication authentication) {

        String email = authentication.getName();
        userService.changePassword(request, email);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Authentication authentication) {

        String email = authentication.getName();
        User user = userService.getCurrentUser(email);

        return ResponseEntity.ok(user);
    }

    @PatchMapping("/me")
    public ResponseEntity<UpdateUser> updateUserInfo(
            @Valid @RequestBody UpdateUser updateData,
            Authentication authentication) {

        String email = authentication.getName();
        UpdateUser updatedUser = userService.updateUser(updateData, email);

        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateUserImage(
            @RequestParam("image") MultipartFile file,
            Authentication authentication) {

        String email = authentication.getName();
        userService.updateUserImage(file, email);

        log.info("Аватар обновлен для пользователя: {}", email);

        return ResponseEntity.ok().build();
    }

    public static class RegisterUserRequest {

        @Valid
        private User user;

        @javax.validation.constraints.NotBlank(message = "Пароль обязателен")
        @javax.validation.constraints.Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
        private String password;

        public RegisterUserRequest() {}

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}