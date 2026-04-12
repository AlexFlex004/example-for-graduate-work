Материалы для выполнения курсовой работы учениками профессии java-разработчик. 

# "Ads Backend Service"

Бэкенд-приложение для платформы объявлений с поддержкой пользователей, комментариев и системой авторизации.

---

## Функциональность

### Пользователи
- Регистрация
- Авторизация
- Просмотр и редактирование профиля
- Загрузка аватара
- Смена пароля

### Объявления
- Создание объявления с изображением
- Получение списка всех объявлений
- Просмотр детальной информации
- Редактирование и удаление
- Просмотр объявлений текущего пользователя

### Комментарии
- Добавление комментариев к объявлениям
- Просмотр комментариев
- Редактирование и удаление комментариев

### Изображения
- Загрузка изображений
- Получение изображений по id
- Хранение файлов в локальном хранилище

---

## Технологии

- Java 17
- Spring Boot
- Spring Web
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Lombok

---

## Структура проекта


controller/ — REST контроллеры
service/ — бизнес-логика
repository/ — доступ к базе данных
entity/ — JPA сущности
dto/ — модели запросов и ответов
config/ — security и конфигурации


---

## Авторизация

Используется Spring Security.

Роли:
- `USER` — обычный пользователь
- `ADMIN` — администратор

---

## Основные эндпоинты

### Auth

POST /login
POST /register


### Ads

GET /ads
GET /ads/{id}
POST /ads
PATCH /ads/{id}
DELETE /ads/{id}
GET /ads/me
PATCH /ads/{id}/image


### Comments

GET /ads/{id}/comments
POST /ads/{id}/comments
PATCH /ads/{id}/comments/{commentId}
DELETE /ads/{id}/comments/{commentId}


### Users

GET /users/me
PATCH /users
PATCH /users/image
PATCH /users/password


### Images

POST /images/upload
GET /images/{id}


---

## Запуск проекта

### 1. Клонировать проект
### 2. Скачать и установить PostgreSQL:
https://www.postgresql.org/download/

### 3. Скачать и установить PgAdmin:
https://www.pgadmin.org/download/

В PgAdmin задать пароль (запомнить!)

### 4. В PgAdmin query tool (ПКМ по Databases) выполнить:

CREATE DATABASE skyavito;

CREATE USER skyavito_user WITH PASSWORD '1234';

GRANT ALL PRIVILEGES ON DATABASE skyavito TO skyavito_user;

### 5. В InteLLiJ IDEA в application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/skyavito?currentSchema=public
spring.jpa.properties.hibernate.default_schema=public
spring.datasource.username=skyavito_user
spring.datasource.password=1234

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL10Dialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.datasource.driver-class-name=org.postgresql.Driver

spring.flyway.baseline-on-migrate=true

spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
spring.servlet.multipart.file-size-threshold=2KB

images.upload.dir=./uploads/images

---

### Тестирование

Использовать Postman

---

## Архитектура проекта

Проект построен по многослойной архитектуре (Layered Architecture):


Client (Frontend / Postman)
↓
Controller Layer (REST API)
↓
Service Layer (Business Logic)
↓
Repository Layer (Data Access)
↓
Database (PostgreSQL)

---

### Детализация слоёв


Controller
- AuthController
- AdController
- CommentController
- ImageController
- UserController

↓
Service
- AuthService
- AdService
- CommentService
- ImageService
- UserService

↓
Repository (Spring Data JPA)
- UserRepository
- AdRepository
- CommentRepository
- RoleRepository

↓
Database (PostgreSQL)
- users
- ads
- comments
- roles


### Модели данных

---

Entity Layer:
- UserEntity
- AdEntity
- CommentEntity
- RoleEntity

DTO Layer:
- User / UpdateUser / Register
- Ad / Ads / ExtendedAd
- Comment / Comments
- CreateOrUpdate DTOs

---

### Security Flow


Request
↓

Spring Security Filter Chain
↓

UserDetailsService (CustomUserDetailsService)
↓

Authentication (email + password)
↓

Controller Access Granted / Denied

---

### File Storage


Client uploads image
↓
ImageController
↓
ImageService
↓
Local File System (uploads/images/)
↓
Image URL returned to client

---

## Автор
Алексеева Александра

