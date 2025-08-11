package com.miApp.AppS.Impl;

import com.miApp.AppS.dto.UserDTO;
import com.miApp.AppS.repository.UserRepository;
import com.miApp.AppS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public UserServiceImpl() {
        this.userRepository = null; // This is not a good practice, but included to match the constructor signature.
    }

    @Override
    public UserDTO findAllUsers() {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
