package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User getUser(Integer id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toDto(entity);
    }

    public User updateUser(Integer id, UpdateUser updateUser) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        entity.setFirstName(updateUser.getFirstName());
        entity.setLastName(updateUser.getLastName());
        entity.setPhone(updateUser.getPhone());

        UserEntity saved = userRepository.save(entity);

        return userMapper.toDto(saved);
    }

    public void setPassword(NewPassword request) {
        // позже реализуешь логику
    }

    public User getCurrentUser() {
        // временно (пока нет security)
        return getUser(1);
    }

    public UpdateUser updateUserProfile(UpdateUser request) {
        // временно можно просто вернуть
        return request;
    }

    public void updateUserImage() {
        // заглушка
    }
}
