package ru.skypro.homework.dto.ad;

/**
 * DTO для создания или обновления объявления.
 * Используется для передачи данных объявления через API.
 */
public class CreateOrUpdateAd {

    /**
     * Заголовок объявления.
     */
    private String title;

    /**
     * Описание объявления.
     */
    private String description;

    /**
     * Цена объявления.
     */
    private Integer price;

    public CreateOrUpdateAd() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
