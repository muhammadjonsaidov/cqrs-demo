package com.example.cqrsdemo.cqrs.flow;

import com.example.cqrsdemo.cqrs.command.CreateUserCommand;
import com.example.cqrsdemo.cqrs.command.CreateUserCommandHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/flow")
@RequiredArgsConstructor
@Tag(name = "POST user-seek-resource", description = "Barcha command (yozish) operatsiyalari")
public class UserFlowResource {

    private final CreateUserCommandHandler createUserCommandHandler;

    @PostMapping("/create-user-flow")
    @Operation(summary = "Create User Flow (Foydalanuvchi yaratish)")
    public UUID createUserFlow(@RequestBody CreateUserCommand command) {
        return createUserCommandHandler.handle(command);
    }
}
