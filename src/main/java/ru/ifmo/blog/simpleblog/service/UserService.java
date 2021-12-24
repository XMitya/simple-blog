package ru.ifmo.blog.simpleblog.service;


import ru.ifmo.blog.simpleblog.model.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> findUser(long id);
}
