package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comment.Comment;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;
import ru.skypro.homework.service.CommentService;

import javax.validation.Valid;

/**
 * Контроллер для работы с комментариями к объявлениям.
 * Предоставляет API для получения, добавления, обновления и удаления комментариев.
 */
@RestController
@RequestMapping("/ads/{id}/comments")
@RequiredArgsConstructor
@Validated
public class CommentController {

    private final CommentService commentService;

    /**
     * Получает список комментариев к объявлению.
     *
     * @param adId идентификатор объявления
     * @return список комментариев к указанному объявлению
     */
    @GetMapping
    public ResponseEntity<Comments> getComments(
            @PathVariable("id") Integer adId) {

        return ResponseEntity.ok(commentService.getCommentsByAdId(adId));
    }

    /**
     * Добавляет новый комментарий к объявлению.
     *
     * @param adId идентификатор объявления
     * @param commentRequest данные комментария
     * @param authentication текущий пользователь
     * @return созданный комментарий
     */
    @PostMapping
    public ResponseEntity<Comment> addComment(
            @PathVariable("id") Integer adId,
            @Valid @RequestBody CreateOrUpdateComment commentRequest,
            Authentication authentication) {

        Comment newComment = commentService.addComment(
                adId,
                commentRequest,
                authentication.getName()
        );

        return ResponseEntity.ok(newComment);
    }

    /**
     * Обновляет комментарий к объявлению.
     *
     * @param adId идентификатор объявления
     * @param commentId идентификатор комментария
     * @param commentRequest новые данные комментария
     * @return обновлённый комментарий
     */
    @PatchMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable("id") Integer adId,
            @PathVariable Integer commentId,
            @Valid @RequestBody CreateOrUpdateComment commentRequest) {

        Comment updatedComment = commentService.updateComment(
                adId,
                commentId,
                commentRequest
        );

        return ResponseEntity.ok(updatedComment);
    }

    /**
     * Удаляет комментарий к объявлению.
     *
     * @param adId идентификатор объявления
     * @param commentId идентификатор комментария
     * @return пустой ответ после удаления
     */
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable("id") Integer adId,
            @PathVariable Integer commentId) {

        commentService.deleteComment(adId, commentId);
        return ResponseEntity.ok().build();
    }
}