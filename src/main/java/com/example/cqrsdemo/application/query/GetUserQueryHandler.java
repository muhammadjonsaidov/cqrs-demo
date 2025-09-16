package com.example.cqrsdemo.application.query;

import com.example.cqrsdemo.domain.exception.UsernameAlreadyExistsException;
import com.example.cqrsdemo.infrastructure.persistence.jpa.UserViewJpaEntity;
import com.example.cqrsdemo.infrastructure.persistence.jpa.UserViewJpaRepository;
import com.example.cqrsdemo.interfaces.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserQueryHandler {

    private final UserViewJpaRepository userViewJpaRepository;

    public UserDto handle(GetUserQuery query) {
        return userViewJpaRepository.findByUsername(query.getUsername())
                .map(this::toDto)
                .orElseThrow(() -> new UsernameAlreadyExistsException("Foydalanuvchi topilmadi: " + query.getUsername()));
    }

    private UserDto toDto(UserViewJpaEntity view) {
        return UserDto.builder()
                .id(view.getId())
                .username(view.getUsername())
                .name(view.getName())
                .email(view.getEmail())
                .build();
    }
}
