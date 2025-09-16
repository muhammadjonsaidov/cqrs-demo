package com.example.cqrsdemo.application.command;

import com.example.cqrsdemo.domain.event.UserCreatedEvent;
import com.example.cqrsdemo.domain.exception.UsernameAlreadyExistsException;
import com.example.cqrsdemo.domain.model.User;
import com.example.cqrsdemo.domain.repository.UserRepository;
import com.example.cqrsdemo.infrastructure.event.SpringDomainEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateUserCommandHandler {

    private final UserRepository userRepository;

    private final SpringDomainEventPublisher eventPublisher;


    public UUID handle(CreateUserCommand command) {

        if (userRepository.findByUsername(command.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException(command.getUsername());
        }

        UUID newId = UUID.randomUUID();
        User user = User.create(newId, command.getUsername(), command.getName(), command.getEmail());
        userRepository.save(user);

        eventPublisher.publish(new UserCreatedEvent(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getEmail()
        ));

        return user.getId();
    }
}
