package ru.skypro.homework.dto.user;

/**
 * DTO ответа при успешной аутентификации пользователя.
 * Содержит токен доступа.
 */
public class LoginResponse {

    /**
     * Токен доступа (JWT или аналог).
     */
    private String token;

    public LoginResponse() {}

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
