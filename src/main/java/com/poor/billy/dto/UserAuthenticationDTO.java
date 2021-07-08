package com.poor.billy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthenticationDTO {

    private String login;

    private String password;
}