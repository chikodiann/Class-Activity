package com.example.classactivity.controller;

import com.example.classactivity.DTO.UserDTO;
import com.example.classactivity.entity.User;
import com.example.classactivity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private UserDTO userDTO;

    @GetMapping("/")
    public List<UserDTO> getUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userRepository.save(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(userDTO.getName());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPassword(userDTO.getPassword());

            return userRepository.save(existingUser);
        }
        else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
