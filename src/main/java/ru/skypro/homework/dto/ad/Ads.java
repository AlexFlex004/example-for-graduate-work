package ru.skypro.homework.dto.ad;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * DTO списка объявлений.
 * Используется для передачи коллекции объявлений вместе с их количеством.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ads {

    /**
     * Общее количество объявлений.
     */
    private Integer count;

    /**
     * Список объявлений.
     */
    private List<Ad> results;
}
