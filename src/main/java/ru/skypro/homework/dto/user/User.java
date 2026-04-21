package ru.skypro.homework.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO пользователя.
 * Используется для передачи данных пользователя через API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * Уникальный идентификатор пользователя.
     */
    private Integer id;

    /**
     * Email пользователя.
     */
    private String email;

    /**
     * Имя пользователя.
     */
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    private String lastName;

    /**
     * Контактный телефон пользователя.
     */
    private String phone;

    /**
     * Роль пользователя в системе (USER, ADMIN).
     */
    private String role;

    /**
     * Ссылка на изображение профиля пользователя.
     */
    private String image;
}