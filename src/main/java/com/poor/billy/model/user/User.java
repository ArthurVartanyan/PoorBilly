package com.poor.billy.model.user;

import lombok.Getter;
import lombok.Setter;

/**
 * User class.
 *
 * @author King Arthuro Vartanyan / 29.06.2021
 */
@Getter
@Setter
public class User {

    /**
     * Username
     */
    private String name;

    /**
     * User surname
     */
    private String lastName;

    /**
     * User role
     */
    private Role role;

    /**
     * User login
     */
    private String login;

    /**
     * User password
     */
    private String password;
}