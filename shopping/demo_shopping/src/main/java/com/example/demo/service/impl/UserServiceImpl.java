package com.example.demo.service.impl;


import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(userDTO.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            user.setRoleId(userDTO.getRoleId());

            return modelMapper.map(userRepository.save(user), UserDTO.class);
        }
        throw new RuntimeException("User existed");
    }

    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    public UserDTO findUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDTO.class);
        }
        throw new RuntimeException("User not found");
    }

    /**
     * Update User Profile
     *
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(userDTO.getEmail()));
        if (user.isPresent()) {
            User userModel = user.get();
            userModel.setEmail(userDTO.getEmail());
            return modelMapper.map(userRepository.save(userModel),UserDTO.class);
        }
        throw new RuntimeException("User not found");
    }

    /**
     * Change Password
     *
     * @param userDTO
     * @param newPassword
     * @return
     */
    @Override
    public UserDTO changePassword(UserDTO userDTO, String newPassword) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(userDTO.getEmail()));
        if (user.isPresent()) {
            User userModel = user.get();
            userModel.setPassword(bCryptPasswordEncoder.encode(newPassword));
            return modelMapper.map(userRepository.save(userModel),UserDTO.class);
        }
        throw new RuntimeException("User not found");
    }

}
