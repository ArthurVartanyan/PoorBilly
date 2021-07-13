package com.poor.billy.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRegistrationDTO {

    @NotBlank(message = "This field can not be empty!")
    @Size(max = 35, message = "Please, enter correct name!")
    private String name;

    @NotBlank(message = "This field can not be empty!")
    @Size(max = 35, message = "Please, enter correct lastname!")
    private String lastName;

    @NotBlank(message = "This field can not be empty!")
    @Size(min = 6, max = 20, message = "Login length cannot be less then 6 and more then 20 letters!")
    private String login;

    @NotBlank(message = "This field can not be empty!")
    @Size(min = 6, message = "Password length cannot be less then 6 letters!")
    private String password;

    @NotBlank(message = "Please, re-enter your password!")
    private String passwordControl;
}