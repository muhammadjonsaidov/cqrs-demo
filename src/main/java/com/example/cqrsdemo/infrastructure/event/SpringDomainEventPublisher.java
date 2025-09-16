package com.example.cqrsdemo.infrastructure.event;

import com.example.cqrsdemo.domain.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringDomainEventPublisher {

    private final ApplicationEventPublisher publisher;

    public void publish(UserCreatedEvent event) {
        publisher.publishEvent(event);
    }
}
