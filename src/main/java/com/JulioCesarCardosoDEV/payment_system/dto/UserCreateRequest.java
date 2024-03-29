package com.JulioCesarCardosoDEV.payment_system.dto;

import com.JulioCesarCardosoDEV.payment_system.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
        @NotNull(message = "O nome não pode ser nulo")
        @NotBlank(message = "O nome não pode ser vazio")
        @Size(min = 1, message = "O nome deve conter no mínimo 2 letras")
        String name,

        @NotNull(message = "Email não pode ser nulo")
        @NotBlank(message = "Email não pode ser vazio")
        @Email
        String email,
        
        @NotNull(message = "A senha não pode ser nula")
        @NotBlank(message = "A senha não pode ser vazia")
        @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres")
        String password,

        @NotNull(message = "Role não pode ser nula")
        @NotBlank(message = "Role não pode ser vazia")
        String role

        ) {

    public User toModel(){

        return new User(name, email, password, role);
    }

}
