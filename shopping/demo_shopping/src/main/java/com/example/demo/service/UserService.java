package com.example.demo.service;


import com.example.demo.dto.UserDTO;

public interface UserService {
    /**
     * Register a new user
     *
     * @param userDTO
     * @return
     */
    UserDTO addUser(UserDTO userDTO) throws Exception;

    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    UserDTO findUserByEmail(String email);

    /**
     * Update profile of the user
     *
     * @param userDTO
     * @return
     */
    UserDTO updateUser(UserDTO userDTO);

    /**
     * Update password
     *
     * @param newPassword
     * @return
     */
    UserDTO changePassword(UserDTO userDTO, String newPassword);
}
