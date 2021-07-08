package com.poor.billy.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poor.billy.model.user.Role;
import com.poor.billy.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Spring Security wrapper for class {@link User}.
 *
 * @author Arthur Vartanyan a.k.a. King Arthuro
 * @version 2.0
 */
@Getter
@Setter
@AllArgsConstructor
public class JWTUser implements UserDetails {

    private Long id;

    private String name;

    private String lastName;

    private String login;

    private String password;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

    /**
     * Возвращает авторизованного пользователя
     */
    public static JWTUser getCurrentUser() {
        return (JWTUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * Возвращает ID авторизованного пользователя
     */
    public static Long getCurrentUserID() {
        return JWTUser.getCurrentUser().getId();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}