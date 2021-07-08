package com.poor.billy.security.jwt;

import com.poor.billy.model.user.User;

/**
 * Implementation of Factory Method for class {@link JWTUser}.
 *
 * @author King Arthuro
 * @version 2.0
 */

public final class JWTUserFactory {

    public JWTUserFactory() {
    }

    public static JWTUser create(User user) {
        return new JWTUser(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getLogin(),
                user.getPassword(),
                user.getRole()
        );
    }
}