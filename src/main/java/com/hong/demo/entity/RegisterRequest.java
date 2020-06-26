package com.hong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotNull
    @NotBlank
    @Size(min = 4)
    private String userName;

    @NotNull
    @NotBlank
    @Size(min = 4)
    private String password;

    @NotNull
    @Email
    private String email;
}
