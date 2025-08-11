package com.miApp.AppS.service;

import com.miApp.AppS.dto.UserDTO;

public interface UserService {
    UserDTO findAllUsers();

    //UserDTO authenticateUser(String email, String password);

    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long userId);
    UserDTO updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);

}
