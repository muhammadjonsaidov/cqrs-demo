package com.example.cqrsdemo.infrastructure;

import com.example.cqrsdemo.domain.model.User;
import com.example.cqrsdemo.domain.repository.UserRepository;
import com.example.cqrsdemo.infrastructure.persistence.jpa.UserJpaEntity;
import com.example.cqrsdemo.infrastructure.persistence.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public void save(User user) {
        UserJpaEntity entity = UserJpaEntity.from(user);
        jpaRepository.save(entity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaRepository.findByUsername(username)
                .map(UserJpaEntity::toDomain);
    }
}
