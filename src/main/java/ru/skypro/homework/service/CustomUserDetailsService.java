package ru.skypro.homework.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.repository.UserRepository;

import java.util.List;
import java.util.Optional;


/**
 * Реализация {@link UserDetailsService} для загрузки пользователей из базы данных.
 * Используется Spring Security для аутентификации пользователей по email.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Создаёт сервис загрузки пользователей.
     *
     * @param userRepository репозиторий пользователей
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Загружает пользователя по email для аутентификации Spring Security.
     *
     * @param email email пользователя
     * @return объект {@link UserDetails} для Spring Security
     * @throws UsernameNotFoundException если пользователь не найден
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String roleName = Optional.ofNullable(user.getRole())
                .map(role -> role.getName())
                .orElse("USER");

        String authority = roleName.startsWith("ROLE_")
                ? roleName
                : "ROLE_" + roleName;

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(authority)
                .disabled(!Boolean.TRUE.equals(user.getEnabled()))
                .build();
    }
}