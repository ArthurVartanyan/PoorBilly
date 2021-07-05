package com.poor.billy.dto;

import com.poor.billy.model.user.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {

    private String name;

    private String lastName;

    private String login;

    private String password;

    private String passwordControl;
}