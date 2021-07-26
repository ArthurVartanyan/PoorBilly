package com.poor.billy.security;

import com.poor.billy.model.user.User;
import com.poor.billy.repository.UserRepository;
import com.poor.billy.security.jwt.JWTUser;
import com.poor.billy.security.jwt.JWTUserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JWTUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new AuthenticationServiceException("There is no user with such data!"));

        JWTUser jwtUser = JWTUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}