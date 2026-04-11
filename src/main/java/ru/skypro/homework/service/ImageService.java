package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;


/**
 * Сервис для работы с изображениями.
 * Обеспечивает сохранение, получение и удаление изображений в файловом хранилище.
 */
public interface ImageService {

    /**
     * Сохраняет изображение в хранилище.
     *
     * @param file файл изображения
     * @return URL сохранённого изображения
     */
    String saveImage(MultipartFile file);

    /**
     * Удаляет изображение из хранилища.
     *
     * @param imageUrl URL изображения для удаления
     */
    void deleteImage(String imageUrl);

    /**
     * Получает изображение по имени файла.
     *
     * @param filename имя файла изображения
     * @return изображение в виде массива байтов
     */
    byte[] getImage(String filename);
}