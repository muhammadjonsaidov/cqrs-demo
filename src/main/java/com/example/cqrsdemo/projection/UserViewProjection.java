package com.example.cqrsdemo.projection;

import com.example.cqrsdemo.event.UserCreatedEvent;
import com.example.cqrsdemo.model.UserView;
import com.example.cqrsdemo.repository.UserViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserViewProjection {

    private final UserViewRepository userViewRepository;

    @Async // ⚡️ asinxron ishlaydi — web threadni band qilmaydi
    @EventListener // 👂 eventni tinglaydi
    @Transactional(propagation = Propagation.REQUIRES_NEW) // alohida transaction
    public void handleUserCreated(UserCreatedEvent event) {
        UserView userView = UserView.builder()
                .id(event.getUserId())
                .username(event.getUsername())
                .name(event.getName())
                .email(event.getEmail())
                .build();

        userViewRepository.save(userView); // ✅ read modelga yozdik

        System.out.println("✅ [EVENT] UserView created for username: " + event.getUsername());
    }
}
