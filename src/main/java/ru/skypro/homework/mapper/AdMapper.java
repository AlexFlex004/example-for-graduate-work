package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.ad.Ad;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.entity.AdEntity;
import org.springframework.stereotype.Component;

/**
 * Маппер для преобразования между сущностью объявления (AdvertisementEntity)
 * и DTO (Ad). Также содержит методы для создания и обновления сущности по DTO.
 */
@Component
public class AdMapper {

    public Ad toDto(AdEntity entity) {
        Ad dto = new Ad();
        dto.setPk(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        if (entity.getAuthor() != null) {
            dto.setAuthor(entity.getAuthor().getId());
        }
        return dto;
    }

    public AdEntity toEntity(CreateOrUpdateAd dto) {
        AdEntity entity = new AdEntity();
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public void updateEntity(AdEntity entity, CreateOrUpdateAd dto) {
        if (dto.getTitle() != null) entity.setTitle(dto.getTitle());
        if (dto.getPrice() != null) entity.setPrice(dto.getPrice());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
    }
}
