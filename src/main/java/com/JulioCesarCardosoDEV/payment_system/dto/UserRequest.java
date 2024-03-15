package com.JulioCesarCardosoDEV.payment_system.dto;

import com.JulioCesarCardosoDEV.payment_system.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull(message = "O nome não pode ser nulo")
        @NotBlank(message = "O nome não pode ser vazio")
        @Size(min = 1, message = "O nome deve conter no minimo 2 letras")
        String name,

        @NotNull(message = "Email não pode ser nulo")
        @NotBlank(message = "Email não pode ser vazio")
        @Email
        String email,
        
        @NotNull(message = "A senha não pode ser nula")
        @NotBlank(message = "A senha não pode ser vazia")
        @Size(min = 8, message = "A senha deve conter no minímo 8 caracteres")
        String password) {

    public User toModel(){
        return new User(name, email, password);
    }

}
