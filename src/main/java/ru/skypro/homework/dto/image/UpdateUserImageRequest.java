package ru.skypro.homework.dto.image;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


/**
 * DTO для обновления изображения пользователя.
 * Используется для передачи файла изображения через API.
 */
@Data
public class UpdateUserImageRequest {

    /**
     * Файл изображения пользователя.
     */
    private MultipartFile image;
}