package ru.skypro.homework.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * DTO для обновления данных пользователя.
 * Используется для изменения персональной информации профиля.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUser {

    /**
     * Имя пользователя.
     */
    @Size(min = 1, max = 10, message = "Имя должно быть от 1 до 10 символов")
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    @Size(min = 1, max = 10, message = "Фамилия должна быть от 1 до 10 символов")
    private String lastName;

    /**
     * Номер телефона пользователя.
     */
    @Pattern(
            regexp = "^(\\+7|8)?[\\s()-]*\\d{3}[\\s()-]*\\d{3}[\\s()-]*\\d{2}[\\s()-]*\\d{2}$",
            message = "Некорректный формат телефона"
    )
    private String phone;
}
