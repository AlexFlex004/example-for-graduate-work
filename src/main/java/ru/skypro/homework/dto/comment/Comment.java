package ru.skypro.homework.dto.comment;

/**
 * DTO комментария.
 * Используется для передачи информации о комментарии в API.
 */
public class Comment {

    /**
     * Уникальный идентификатор комментария.
     */
    private Integer pk;

    /**
     * Идентификатор автора комментария.
     */
    private Integer author;

    /**
     * Ссылка на изображение автора.
     */
    private String authorImage;

    /**
     * Имя автора комментария.
     */
    private String authorFirstName;

    /**
     * Время создания комментария (timestamp).
     */
    private Long createdAt;

    /**
     * Текст комментария.
     */
    private String text;

    public Comment() {
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
