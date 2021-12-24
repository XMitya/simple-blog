package ru.ifmo.blog.simpleblog.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ifmo.blog.simpleblog.entity.UserEntity;
import ru.ifmo.blog.simpleblog.model.User;
import ru.ifmo.blog.simpleblog.repository.UserRepository;
import ru.ifmo.blog.simpleblog.service.UserService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        var toRegister = toEntity(user)
                .toBuilder()
                .id(null)
                .createdAt(LocalDateTime.now(ZoneId.of("UTC")))
                .build();

        log.debug("Registering user {}", toRegister);

        return toUser(userRepository.save(toRegister))
                .withPassword(null);
    }

    @Override
    public Optional<User> findUser(long id) {
        return userRepository.findById(id)
                .map(this::toUser);
    }

    private UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getAge()
        );
    }

    private User toUser(UserEntity user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getAge()
        );
    }
}
