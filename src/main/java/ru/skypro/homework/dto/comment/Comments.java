package ru.skypro.homework.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * DTO списка комментариев.
 * Используется для передачи коллекции комментариев вместе с их количеством.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    /**
     * Общее количество комментариев.
     */
    private Integer count;

    /**
     * Список комментариев.
     */
    private List<Comment> results;
}
