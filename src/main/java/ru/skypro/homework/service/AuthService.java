package ru.skypro.homework.service;

import ru.skypro.homework.dto.user.Register;

/**
 * Сервис для аутентификации и регистрации пользователей.
 * Отвечает за проверку учетных данных и создание новых пользователей.
 */
public interface AuthService {

    /**
     * Выполняет аутентификацию пользователя по логину и паролю.
     *
     * @param userName имя пользователя (логин)
     * @param password пароль пользователя
     * @return true, если аутентификация успешна, иначе false
     */
    boolean login(String userName, String password);

    /**
     * Регистрирует нового пользователя в системе.
     *
     * @param register данные для регистрации пользователя
     * @return true, если регистрация успешна, иначе false
     */
    boolean register(Register register);
}