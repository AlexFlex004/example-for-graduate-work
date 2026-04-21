package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UpdateUser;
import ru.skypro.homework.dto.user.User;



/**
 * Сервис для работы с пользователями.
 * Отвечает за управление профилем пользователя: изменение данных, пароля и изображения.
 */
public interface UserService {

    /**
     * Изменяет пароль текущего пользователя.
     *
     * @param newPassword новый пароль пользователя
     * @param email email текущего пользователя
     */
    void changePassword(NewPassword newPassword, String email);

    /**
     * Получает данные текущего пользователя.
     *
     * @param email email пользователя
     * @return данные пользователя
     */
    User getCurrentUser(String email);

    /**
     * Обновляет информацию о пользователе.
     *
     * @param updateUser новые данные пользователя
     * @param email email текущего пользователя
     * @return обновлённые данные пользователя
     */
    UpdateUser updateUser(UpdateUser updateUser, String email);

    /**
     * Обновляет изображение профиля пользователя.
     *
     * @param file файл изображения
     * @param email email текущего пользователя
     */
    void updateUserImage(MultipartFile file, String email);
}
