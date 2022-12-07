package ru.gb.controler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;

    @Email
    private String email;

    private Set<RoleDto> roles;

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDto(Long id, String username, String email, Set<RoleDto> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
