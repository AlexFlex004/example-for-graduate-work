package ru.skypro.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


/**
 * Сущность пользователя системы.
 * Хранит данные пользователя, его роль, объявления и комментарии.
 * Используется для аутентификации, авторизации и работы с профилем.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    /**
     * Уникальный идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Email пользователя (используется как логин).
     * Должен быть уникальным.
     */
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    /**
     * Имя пользователя.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Контактный телефон пользователя.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Ссылка на изображение профиля пользователя.
     */
    @Column(name = "image")
    private String image;

    /**
     * Пароль пользователя (хранится в зашифрованном виде).
     */
    @Column(name = "password")
    private String password;

    /**
     * Флаг активности пользователя.
     * False — пользователь заблокирован или неактивен.
     */
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    /**
     * Объявления, созданные пользователем.
     */
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<AdEntity> ads;

    /**
     * Комментарии пользователя.
     */
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    /**
     * Роль пользователя в системе (USER, ADMIN и т.д.).
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}