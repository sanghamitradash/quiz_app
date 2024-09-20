package com.example.quizapp.ServiceImpl;

import com.example.quizapp.dto.LoginRequestDto;
import com.example.quizapp.dto.RegistrationRequestDto;
import com.example.quizapp.model.AppUser;
import com.example.quizapp.repository.UserRepository;
import com.example.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> registerUser(RegistrationRequestDto request){
        AppUser user = new AppUser();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        userRepository.save(user);
        return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> loginUser(LoginRequestDto loginRequest){
        AppUser user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
        if(user == null){
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }
}
