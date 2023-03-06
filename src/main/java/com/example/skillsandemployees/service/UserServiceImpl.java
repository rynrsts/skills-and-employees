package com.example.skillsandemployees.service;


import com.example.skillsandemployees.model.UserModel;
import com.example.skillsandemployees.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username);
        if (userModel == null) {
            throw new UsernameNotFoundException("Invalid user");
        }
        return new User(userModel.getUsername(), userModel.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
