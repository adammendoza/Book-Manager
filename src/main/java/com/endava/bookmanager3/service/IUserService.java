package com.endava.bookmanager3.service;

import com.endava.bookmanager3.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);

    User save(User user);
}
