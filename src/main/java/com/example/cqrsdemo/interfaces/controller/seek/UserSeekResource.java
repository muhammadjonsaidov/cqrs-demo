package com.example.cqrsdemo.interfaces.controller.seek;

import com.example.cqrsdemo.application.query.GetUserQuery;
import com.example.cqrsdemo.application.query.GetUserQueryHandler;
import com.example.cqrsdemo.interfaces.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seek")
@RequiredArgsConstructor
@Tag(name = "POST user-flow-resource", description = "Barcha Query (o'qish) operatsiyalari")
public class UserSeekResource {

    private final GetUserQueryHandler getUserQueryHandler;

    @PostMapping("/get-user-seek")
    @Operation(summary = "Get User Seek (Foydalanuvchini Id orqali olish)")
    public UserDto getUser(@RequestBody GetUserQuery query) {
        return getUserQueryHandler.handle(query);
    }
}
