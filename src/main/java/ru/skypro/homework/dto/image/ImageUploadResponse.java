package ru.skypro.homework.dto.image;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * DTO ответа при загрузке изображения.
 * Содержит информацию о сохранённом файле.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageUploadResponse {

    /**
     * Уникальный идентификатор изображения.
     */
    private String id;

    /**
     * URL для доступа к изображению.
     */
    private String url;

    /**
     * Размер файла в байтах.
     */
    private Long size;

    /**
     * MIME-тип изображения.
     */
    private String contentType;

    /**
     * Оригинальное имя файла при загрузке.
     */
    private String originalFilename;
}
