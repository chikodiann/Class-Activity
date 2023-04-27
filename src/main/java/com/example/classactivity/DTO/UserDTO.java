package com.example.classactivity.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class UserDTO {
    private  String name;
    private String email;
    private String password;
}
