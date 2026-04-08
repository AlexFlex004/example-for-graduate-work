package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comment.Comment;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;
import ru.skypro.homework.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/ads/{adId}/comments")
public class CommentsController {

    private final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Получить все комментарии к объявлению
    @GetMapping
    public List<Comment> getComments(@PathVariable Integer adId) {
        return commentService.getCommentsByAd(adId);
    }

    // Добавить комментарий
    @PostMapping
    public Comment addComment(@PathVariable Integer adId,
                              @RequestBody CreateOrUpdateComment dto,
                              @RequestParam Integer userId) {
        return commentService.addComment(adId, dto, userId);
    }

    // Удалить комментарий
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
    }
}