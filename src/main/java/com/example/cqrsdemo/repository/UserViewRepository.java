package com.example.cqrsdemo.repository;

import com.example.cqrsdemo.dto.UserDto;
import com.example.cqrsdemo.model.User;
import com.example.cqrsdemo.model.UserView;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

// Hozircha oddiy, keyinchalik materialized view / Redis / ES ga o'tkazish mumkin
public interface UserViewRepository extends CrudRepository<UserView, UUID> {

    Optional<UserView> findByUsername(String username);
}
