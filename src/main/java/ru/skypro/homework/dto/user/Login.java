package ru.skypro.homework.dto.user;


/**
 * DTO для входа пользователя в систему.
 * Используется для передачи учетных данных при аутентификации.
 */
public class Login {

    /**
     * Имя пользователя (логин).
     */
    private String username;

    /**
     * Пароль пользователя.
     */
    private String password;

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
