package com.poor.billy.service;

import com.poor.billy.dto.UserRegistrationDTO;
import com.poor.billy.exceptions.UserIllegalArgumentException;
import com.poor.billy.model.user.Role;
import com.poor.billy.model.user.User;
import com.poor.billy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    // DI
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method register new user in system(default - FINANCIER type)
     *
     * @param userRegistrationDTO - DTO for work with registration user
     * @return - new users ID
     */
    public Long registration(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setName(userRegistrationDTO.getName());
        user.setLastName(userRegistrationDTO.getLastName());
        user.setLogin(userRegistrationDTO.getLogin());
        user.setRole(Role.FINANCIER);
        if (userRegistrationDTO.getPassword().equals(userRegistrationDTO.getPasswordControl())) {
            user.setPassword(userRegistrationDTO.getPassword());
        } else {
            throw new UserIllegalArgumentException("Error! Password mismatch!");
        }
        return userRepository.save(user).getId();
    }
}