package com.example.cqrsdemo.cqrs.query;

import com.example.cqrsdemo.dto.UserDto;
import com.example.cqrsdemo.exception.UserNotFoundException;
import com.example.cqrsdemo.model.UserView;
import com.example.cqrsdemo.repository.UserViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserQueryHandler {

    private final UserViewRepository userViewRepository;

    public UserDto handle(GetUserQuery query) {
        return userViewRepository.findByUsername(query.getUsername())
                .map(this::toDto)
                .orElseThrow(() -> new UserNotFoundException("Foydalanuvchi topilmadi: " + query.getUsername()));
    }

    private UserDto toDto(UserView view) {
        return UserDto.builder()
                .id(view.getId())         // ichki ID — frontendga ham berilishi mumkin, lekin asosiy emas
                .username(view.getUsername())
                .name(view.getName())
                .email(view.getEmail())
                .build();
    }
}
