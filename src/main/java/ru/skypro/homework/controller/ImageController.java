package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.image.ImageUploadResponse;
import ru.skypro.homework.service.ImageService;


/**
 * Контроллер для загрузки и получения изображений.
 * Предоставляет API для сохранения изображений на сервере и получения их по идентификатору.
 */
@Slf4j
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    /**
     * Загружает изображение на сервер.
     *
     * @param file файл изображения
     * @return информация о загруженном изображении (id, url, размер, тип)
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageUploadResponse> uploadImage(
            @RequestParam("image") MultipartFile file) {

        log.info("Загрузка изображения: {}", file.getOriginalFilename());

        String imageUrl = imageService.saveImage(file);

        String filename = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        String uuid = filename.contains(".")
                ? filename.substring(0, filename.lastIndexOf("."))
                : filename;

        ImageUploadResponse response = ImageUploadResponse.builder()
                .id(uuid)
                .url(imageUrl)
                .size(file.getSize())
                .contentType(file.getContentType())
                .originalFilename(file.getOriginalFilename())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Получает изображение по его идентификатору.
     *
     * @param id идентификатор изображения
     * @return изображение в виде массива байтов или 404, если файл не найден
     */
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {

        log.info("Получение изображения: {}", id);

        String filename = id;

        try {
            byte[] imageBytes = imageService.getImage(filename);

            String extension = filename.contains(".")
                    ? filename.substring(filename.lastIndexOf(".")).toLowerCase()
                    : ".jpg";

            String contentType = switch (extension) {
                case ".png" -> MediaType.IMAGE_PNG_VALUE;
                case ".gif" -> MediaType.IMAGE_GIF_VALUE;
                case ".webp" -> "image/webp";
                case ".bmp" -> "image/bmp";
                default -> MediaType.IMAGE_JPEG_VALUE;
            };

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(imageBytes);

        } catch (Exception e) {
            log.warn("Изображение не найдено: {}", filename);
            return ResponseEntity.notFound().build();
        }
    }
}
