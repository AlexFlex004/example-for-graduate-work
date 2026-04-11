package ru.skypro.homework.dto.user;

import lombok.Data;
import ru.skypro.homework.entity.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * DTO для регистрации нового пользователя.
 * Содержит данные, необходимые для создания учетной записи.
 */
@Data
public class Register {

    /**
     * Имя пользователя (логин).
     */
    @NotBlank
    @Size(min = 1, max = 32)
    private String username;

    /**
     * Пароль пользователя.
     */
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

    /**
     * Имя пользователя.
     */
    @NotBlank
    @Size(min = 1, max = 16)
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    @NotBlank
    @Size(min = 1, max = 16)
    private String lastName;

    /**
     * Номер телефона пользователя.
     * Формат: +7XXXXXXXXXX
     */
    @NotBlank
    @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
    private String phone;

    /**
     * Роль пользователя в системе.
     */
    private Role role;
}
