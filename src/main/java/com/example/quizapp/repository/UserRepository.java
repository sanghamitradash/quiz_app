package com.example.quizapp.repository;

import com.example.quizapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserNameAndPassword(String userName, String password);
}
