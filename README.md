Материалы для выполнения курсовой работы учениками профессии java-разработчик. 

# "Ads Backend Service"

Бэкенд-приложение для платформы объявлений с поддержкой пользователей, комментариев и системой авторизации.

---

## О проекте

Сервис реализует REST API для работы с объявлениями:

- регистрация и авторизация пользователей  
- создание и управление объявлениями  
- комментарии к объявлениям  
- разграничение прав доступа (USER / ADMIN)  

Проект построен по классической архитектуре:
**Controller → Service → Repository → DB**

---

## Стек технологий

- Java 17  
- Spring Boot  
- Spring Security  
- Spring Data JPA  
- PostgreSQL  
- Maven  

---

## Архитектура

Controller → принимает HTTP-запросы  
Service → бизнес-логика  
Repository → работа с БД  
Entity → модели базы данных  
DTO → объекты для API  
Mapper → преобразование данных  

---

## Особенности

- Используется `Principal` для получения текущего пользователя  
- Реализован `GlobalExceptionHandler`  
- Проверки безопасности на уровне сервиса  
- Чистая многослойная архитектура  

---

## Быстрый старт

### 1. Клонировать проект
git clone <ссылка на репозиторий>

### 2. Настроить БД
Создать базу данных PostgreSQL и указать параметры в application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/skyavito
spring.datasource.username=skyavito_user
spring.datasource.password=1234

### 3. Запустить приложение
Запустить класс HomeworkApplication

Сервер будет доступен:
http://localhost:8080

---

### Авторизация

Используется Basic Auth

В Postman:
- Authorization → Basic Auth
- Ввести логин и пароль пользователя

---

### Основные эндпоинты

GET /ads — получить объявления  
POST /ads — создать объявление  
GET /ads/{id} — получить объявление  
DELETE /ads/{id} — удалить  

---

### Комментарии

| Метод | Endpoint                             | Описание           |
|------|--------------------------------------|-------------------|
| GET  | /ads/{adId}/comments                | Получить все      |
| POST | /ads/{adId}/comments                | Добавить          |
| DELETE | /ads/{adId}/comments/{commentId} | Удалить           |

---

### Тестирование

Использовать Postman или Swagger (если подключен)

---

## Автор
Алексеева Александра

