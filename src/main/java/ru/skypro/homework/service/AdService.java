package ru.skypro.homework.service;


import org.springframework.stereotype.Service;
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

@Service
public class AdService {

    private final AdRepository adRepository;
    private final UserRepository userRepository;
    private final AdMapper adMapper;

    public AdService(AdRepository adRepository,
                     UserRepository userRepository,
                     AdMapper adMapper) {
        this.adRepository = adRepository;
        this.userRepository = userRepository;
        this.adMapper = adMapper;
    }

    // Все объявления
    public Ads getAllAds() {
        List<Ad> ads = adRepository.findAll()
                .stream()
                .map(adMapper::toDto)
                .collect(Collectors.toList());

        Ads result = new Ads();
        result.setResults(ads);
        result.setCount(ads.size());

        return result;
    }

    // Создание объявления
    public Ad createAd(CreateOrUpdateAd dto, Integer userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        AdEntity entity = adMapper.toEntity(dto);
        entity.setAuthor(user);

        AdEntity saved = adRepository.save(entity);

        return adMapper.toDto(saved);
    }

    // Получить объявление (расширенное)
    public ExtendedAd getExtendedAd(Integer id) {
        AdEntity entity = adRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ad not found"));

        return adMapper.toExtendedDto(entity);
    }

    // Обновить объявление
    public Ad updateAd(Integer id, CreateOrUpdateAd dto) {
        AdEntity entity = adRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ad not found"));

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());

        AdEntity saved = adRepository.save(entity);

        return adMapper.toDto(saved);
    }

    // Удалить
    public void deleteAd(Integer id) {
        adRepository.deleteById(id);
    }

    // Мои объявления
    public Ads getMyAds() {
        // пока заглушка — позже через security
        List<Ad> ads = adRepository.findAll()
                .stream()
                .map(adMapper::toDto)
                .collect(Collectors.toList());

        Ads result = new Ads();
        result.setResults(ads);
        result.setCount(ads.size());

        return result;
    }

    // Обновление изображения
    public void updateImage(Integer id) {
        AdEntity entity = adRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ad not found"));

        // логика загрузки файла будет позже
    }
}
