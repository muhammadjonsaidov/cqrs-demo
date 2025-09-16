package com.example.cqrsdemo.domain.repository;

import com.example.cqrsdemo.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user); //  👈 faqat domain obyektini qabul qiladi

    Optional<User> findByUsername(String username);
}
