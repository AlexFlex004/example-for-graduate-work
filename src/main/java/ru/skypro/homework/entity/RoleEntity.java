package ru.skypro.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Сущность роли пользователя.
 * Используется для хранения ролей в системе авторизации и определения прав доступа.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity {

    /**
     * Уникальный идентификатор роли.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Название роли (например: USER, ADMIN).
     * Должно быть уникальным.
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
