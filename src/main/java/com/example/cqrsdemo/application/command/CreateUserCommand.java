package com.example.cqrsdemo.application.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserCommand {

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;
}
