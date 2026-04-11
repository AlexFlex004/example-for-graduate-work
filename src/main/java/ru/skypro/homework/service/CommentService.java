package ru.skypro.homework.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.comment.Comment;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.CommentEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Сервис для работы с комментариями к объявлениям.
 * Содержит бизнес-логику добавления, получения, обновления и удаления комментариев.
 */
public interface CommentService {

    /**
     * Получает список комментариев для указанного объявления.
     *
     * @param adId идентификатор объявления
     * @return список комментариев к объявлению
     */
    Comments getCommentsByAdId(Integer adId);

    /**
     * Добавляет новый комментарий к объявлению.
     *
     * @param adId идентификатор объявления
     * @param commentRequest данные комментария
     * @param authorEmail email автора комментария
     * @return созданный комментарий
     */
    Comment addComment(Integer adId, CreateOrUpdateComment commentRequest, String authorEmail);

    /**
     * Обновляет комментарий к объявлению.
     *
     * @param adId идентификатор объявления
     * @param commentId идентификатор комментария
     * @param commentRequest новые данные комментария
     * @return обновлённый комментарий
     */
    Comment updateComment(Integer adId, Integer commentId, CreateOrUpdateComment commentRequest);

    /**
     * Удаляет комментарий к объявлению.
     *
     * @param adId идентификатор объявления
     * @param commentId идентификатор комментария
     */
    void deleteComment(Integer adId, Integer commentId);
}