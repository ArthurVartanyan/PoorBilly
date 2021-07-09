package com.poor.billy.controller;

import com.poor.billy.dto.UserAuthenticationDTO;
import com.poor.billy.dto.UserRegistrationDTO;
import com.poor.billy.exceptions.EntityNotFoundException;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.UserRepository;
import com.poor.billy.security.jwt.JWTTokenProvider;
import com.poor.billy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticateManager;

    private final UserRepository userRepository;

    private final JWTTokenProvider jwtTokenProvider;

    @PostMapping("/registration")
    public ResponseEntity<Long> registration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return new ResponseEntity<>(userService.registration(userRegistrationDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody UserAuthenticationDTO authenticationDTO) {
        try {
            String username = authenticationDTO.getLogin();
            authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(username, authenticationDTO.getPassword()));
            User user = userRepository.findByLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));

            String token = jwtTokenProvider.createToken(username, user.getRole());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}