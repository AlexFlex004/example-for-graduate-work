package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comment.Comment;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;

public class CommentsController {

    @GetMapping("/ads/{id}/comments")
    public Comments getComments(@PathVariable Integer id) {
        return new Comments();
    }

    @PostMapping("/ads/{id}/comments")
    public Comment addComment(@PathVariable Integer id,
                              @RequestBody CreateOrUpdateComment request) {
        return new Comment();
    }

    @PatchMapping("/ads/{adId}/comments/{commentId}")
    public Comment updateComment(@PathVariable Integer adId,
                                 @PathVariable Integer commentId,
                                 @RequestBody CreateOrUpdateComment request) {
        return new Comment();
    }

    @DeleteMapping("/ads/{adId}/comments/{commentId}")
    public void deleteComment(@PathVariable Integer adId,
                              @PathVariable Integer commentId) {
    }
}
