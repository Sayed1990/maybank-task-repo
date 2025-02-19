package com.maybanktask.user_management.commonconfig;

import com.maybanktask.user_management.dao.User;
import com.maybanktask.user_management.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        Optional<User> optUser= repository.findByEmail(email);
        User user;
        if(optUser.isPresent()){
            user= optUser.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .build();
        }
        return null;
    }
}
