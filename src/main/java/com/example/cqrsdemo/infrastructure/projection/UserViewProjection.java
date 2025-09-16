package com.example.cqrsdemo.infrastructure.projection;

import com.example.cqrsdemo.domain.event.UserCreatedEvent;
import com.example.cqrsdemo.infrastructure.persistence.jpa.UserViewJpaEntity;
import com.example.cqrsdemo.infrastructure.persistence.jpa.UserViewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserViewProjection {

    private final UserViewJpaRepository userViewJpaRepository;

    @Async
    @EventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handleUserCreated(UserCreatedEvent event) {
        UserViewJpaEntity view = new UserViewJpaEntity();
        view.setId(event.getUserId());
        view.setUsername(event.getUsername());
        view.setName(event.getName());
        view.setEmail(event.getEmail());

        userViewJpaRepository.save(view);

        System.out.println("✅ [PROJECTION] UserView created for: " + event.getUsername());
    }
}
