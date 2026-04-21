package ru.skypro.homework.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.Ad;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.service.AdService;
import org.springframework.security.core.Authentication;

import javax.validation.Valid;

/**
 * Контроллер для работы с объявлениями.
 * Предоставляет REST API для получения, создания, обновления и удаления объявлений,
 * а также управления объявлениями текущего пользователя и изображениями.
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
@Validated
public class AdController {

    private final AdService adService;

    /**
     * Получает список всех объявлений.
     *
     * @return список всех объявлений
     */
    @GetMapping
    public ResponseEntity<Ads> getAllAds() {
        return ResponseEntity.ok(adService.getAllAds());
    }

    /**
     * Получает подробную информацию об объявлении по его ID.
     *
     * @param id идентификатор объявления
     * @return расширенная информация об объявлении
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAd> getAdById(@PathVariable Integer id) {
        return ResponseEntity.ok(adService.getAdById(id));
    }

    /**
     * Создаёт новое объявление.
     *
     * @param dto данные объявления
     * @param image изображение объявления
     * @param authentication текущий авторизованный пользователь
     * @return созданное объявление
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ad> createAd(
            @RequestPart("properties") @Valid CreateOrUpdateAd dto,
            @RequestPart("image") MultipartFile image,
            Authentication authentication) {

        String email = authentication.getName();
        Ad newAd = adService.createAd(dto, image, email);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAd);
    }

    /**
     * Удаляет объявление по ID.
     *
     * @param id идентификатор объявления
     * @param authentication текущий пользователь
     * @return пустой ответ без содержимого
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(
            @PathVariable Integer id,
            Authentication authentication) {

        String email = authentication.getName();
        adService.deleteAd(id, email);

        log.info("Объявление {} удалено пользователем {}", id, email);
        return ResponseEntity.noContent().build();
    }

    /**
     * Обновляет данные объявления.
     *
     * @param id идентификатор объявления
     * @param request новые данные объявления
     * @param authentication текущий пользователь
     * @return обновлённое объявление
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Ad> updateAd(
            @PathVariable Integer id,
            @Valid @RequestBody CreateOrUpdateAd request,
            Authentication authentication) {

        String email = authentication.getName();
        Ad updatedAd = adService.updateAd(id, request, email);

        log.info("Объявление {} обновлено пользователем {}", id, email);
        return ResponseEntity.ok(updatedAd);
    }

    /**
     * Получает все объявления текущего авторизованного пользователя.
     *
     * @param authentication текущий пользователь
     * @return список объявлений пользователя
     */
    @GetMapping("/me")
    public ResponseEntity<Ads> getMyAds(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(adService.getMyAds(email));
    }

    /**
     * Обновляет изображение объявления.
     *
     * @param id идентификатор объявления
     * @param file новое изображение
     * @param authentication текущий пользователь
     * @return обновлённое изображение в виде массива байт
     */
    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> updateImage(
            @PathVariable Integer id,
            @RequestParam("image") MultipartFile file,
            Authentication authentication) {

        String email = authentication.getName();
        byte[] imageBytes = adService.updateAdImage(id, file, email);

        log.info("Изображение объявления {} обновлено пользователем {}", id, email);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(imageBytes);
    }
}
