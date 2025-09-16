package com.example.cqrsdemo.cqrs.command;

import com.example.cqrsdemo.event.UserCreatedEvent;
import com.example.cqrsdemo.model.User;
import com.example.cqrsdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateUserCommandHandler {

    private final UserRepository userRepository;

    private final ApplicationEventPublisher eventPublisher; // 👈 Springning event publish qiluvchisi


    public UUID handle(CreateUserCommand command) {

        if (userRepository.findByUsername(command.getUsername()).isPresent()) {
            throw new RuntimeException("Username allaqachon mavjud: " + command.getUsername());
        }

        User user = User.builder()
                .username(command.getUsername())
                .name(command.getName())
                .email(command.getEmail())
                .build();

        userRepository.save(user);

        // 🔥 EVENTNI CHIQARDIK — read model bu haqda hech narsa bilmaydi!
        eventPublisher.publishEvent(new UserCreatedEvent(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getEmail()
        ));

        return user.getId();
    }
}
