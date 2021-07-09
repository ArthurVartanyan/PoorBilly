package com.poor.billy.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * User class.
 *
 * @author King Arthuro Vartanyan / 29.06.2021
 */
@Getter
@Setter
@Entity
@Table(name = "pg_user", schema = "public")
public class User {

    public static final String ADMIN = "ADMIN";
    public static final String FINANCIER = "FINANCIER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username
     */
    @Column(name = "name")
    private String name;

    /**
     * User surname
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * User role
     */
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * User login
     */
    @Column(name = "login")
    private String login;

    /**
     * User password
     */
    @Column(name = "password")
    private String password;
}