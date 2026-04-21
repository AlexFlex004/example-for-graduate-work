package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.user.Login;
import ru.skypro.homework.dto.user.Register;
import ru.skypro.homework.service.AuthService;

/**
 * Контроллер для аутентификации и регистрации пользователей.
 * Предоставляет API для входа в систему и создания нового пользователя.
 */
@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * Выполняет аутентификацию пользователя.
     *
     * @param login объект с данными для входа (username и password)
     * @return 200 OK если вход успешен, 401 Unauthorized если данные неверны
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {

        boolean success = authService.login(
                login.getUsername(),
                login.getPassword()
        );

        if (success) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * Регистрирует нового пользователя.
     *
     * @param register данные нового пользователя
     * @return 201 Created если регистрация успешна,
     *         400 Bad Request если пользователь уже существует или данные некорректны
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Register register) {

        boolean success = authService.register(register);

        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
