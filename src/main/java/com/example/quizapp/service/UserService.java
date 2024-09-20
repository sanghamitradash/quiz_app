package com.example.quizapp.service;

import com.example.quizapp.dto.LoginRequestDto;
import com.example.quizapp.dto.RegistrationRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<String> registerUser(RegistrationRequestDto registration);

    ResponseEntity<String> loginUser(LoginRequestDto loginRequest);
}
