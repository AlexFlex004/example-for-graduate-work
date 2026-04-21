package ru.skypro.homework.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 * DTO для смены пароля пользователя.
 * Содержит текущий и новый пароль.
 */
public class NewPassword {

    /**
     * Текущий пароль пользователя.
     */
    @NotBlank(message = "Текущий пароль не должен быть пустым")
    @Size(min = 8, max = 16, message = "Текущий пароль должен быть от 8 до 16 символов")
    private String currentPassword;

    /**
     * Новый пароль пользователя.
     */
    @NotBlank(message = "Новый пароль не должен быть пустым")
    @Size(min = 8, max = 16, message = "Новый пароль должен быть от 8 до 16 символов")
    private String newPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}