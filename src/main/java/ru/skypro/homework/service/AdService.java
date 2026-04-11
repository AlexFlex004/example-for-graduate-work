package ru.skypro.homework.service;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.Ad;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Сервис для работы с объявлениями.
 * Содержит бизнес-логику создания, получения, обновления и удаления объявлений,
 * а также управления изображениями и объявлениями текущего пользователя.
 */
public interface AdService {

    /**
     * Получает все объявления.
     *
     * @return список всех объявлений
     */
    Ads getAllAds();

    /**
     * Создаёт новое объявление.
     *
     * @param adDto данные объявления
     * @param image изображение объявления
     * @param email email автора объявления
     * @return созданное объявление
     */
    Ad createAd(CreateOrUpdateAd adDto, MultipartFile image, String email);

    /**
     * Получает подробную информацию об объявлении по ID.
     *
     * @param id идентификатор объявления
     * @return расширенная информация об объявлении
     */
    ExtendedAd getAdById(Integer id);

    /**
     * Удаляет объявление по ID.
     *
     * @param id идентификатор объявления
     * @param email email пользователя, выполняющего удаление
     */
    void deleteAd(Integer id, String email);

    /**
     * Обновляет данные объявления.
     *
     * @param id идентификатор объявления
     * @param request новые данные объявления
     * @param email email пользователя, выполняющего обновление
     * @return обновлённое объявление
     */
    Ad updateAd(Integer id, CreateOrUpdateAd request, String email);

    /**
     * Получает все объявления текущего пользователя.
     *
     * @param email email пользователя
     * @return список объявлений пользователя
     */
    Ads getMyAds(String email);

    /**
     * Обновляет изображение объявления.
     *
     * @param id идентификатор объявления
     * @param file новый файл изображения
     * @param email email пользователя
     * @return изображение в виде массива байтов
     */
    byte[] updateAdImage(Integer id, MultipartFile file, String email);
}
