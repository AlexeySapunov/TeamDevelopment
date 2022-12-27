package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dto.UserBotDto;
import ru.gb.service.BackendUserService;

import java.util.Optional;

@RestController
@RequestMapping("v1/user")
public class BackendUserController {

    private final BackendUserService userService;

    @Autowired
    public BackendUserController(BackendUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    Optional<UserBotDto> findById(@PathVariable Long id) {
        return Optional.ofNullable(userService.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found")));
    }
}
