package ru.skypro.homework.dto.ad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Расширенный DTO объявления.
 * Используется для передачи полной информации об объявлении,
 * включая данные автора и контактную информацию.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExtendedAd {

    /**
     * Уникальный идентификатор объявления.
     */
    private Integer pk;

    /**
     * Имя автора объявления.
     */
    private String authorFirstName;

    /**
     * Фамилия автора объявления.
     */
    private String authorLastName;

    /**
     * Описание объявления.
     */
    private String description;

    /**
     * Email автора объявления.
     */
    private String email;

    /**
     * Ссылка на изображение объявления.
     */
    private String image;

    /**
     * Контактный телефон автора объявления.
     */
    private String phone;

    /**
     * Цена объявления.
     */
    private Integer price;

    /**
     * Заголовок объявления.
     */
    private String title;
}
