package ru.skypro.homework.dto.comment;

/**
 * DTO для создания или обновления комментария.
 * Используется для передачи текста комментария через API.
 */
public class CreateOrUpdateComment {

    /**
     * Текст комментария.
     */
    private String text;

    public CreateOrUpdateComment() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
