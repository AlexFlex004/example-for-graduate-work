package ru.skypro.homework.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Тестовый контроллер для отладки системы аутентификации.
 * Используется для проверки текущего авторизованного пользователя.
 */
@RestController
public class TestController {

    /**
     * Возвращает имя текущего аутентифицированного пользователя.
     *
     * @param auth объект аутентификации Spring Security
     * @return имя пользователя или "NULL", если пользователь не авторизован
     */
    @GetMapping("/debug")
    public String debug(Authentication auth) {
        return auth == null ? "NULL" : auth.getName();
    }
}
