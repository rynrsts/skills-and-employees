package com.example.skillsandemployees.repository;

import com.example.skillsandemployees.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);

}
