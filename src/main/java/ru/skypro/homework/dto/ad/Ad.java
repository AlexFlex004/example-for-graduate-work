package ru.skypro.homework.dto.ad;


/**
 * DTO объявления (краткое представление).
 * Используется для передачи данных объявления в списках и кратких ответах API.
 */
public class Ad {

    /**
     * Уникальный идентификатор объявления.
     */
    private Integer pk;

    /**
     * Идентификатор автора объявления.
     */
    private Integer author;

    /**
     * Ссылка на изображение объявления.
     */
    private String image;

    /**
     * Цена объявления.
     */
    private Integer price;

    /**
     * Заголовок объявления.
     */
    private String title;

    public Ad() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
