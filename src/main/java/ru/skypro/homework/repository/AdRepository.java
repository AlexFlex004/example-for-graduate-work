package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface AdRepository extends JpaRepository<AdEntity, Integer> {

    /**
     * Возвращает объявления, созданные конкретным пользователем.
     *
     * @param author автор объявлений
     * @return список объявлений пользователя
     */
    List<AdEntity> findAllByAuthor(UserEntity author);

    /**
     * Возвращает email автора объявления по идентификатору объявления.
     *
     * @param adId идентификатор объявления
     * @return email автора, если объявление найдено
     */
    Optional<Object> findAuthorEmailById(Integer adId);
}
