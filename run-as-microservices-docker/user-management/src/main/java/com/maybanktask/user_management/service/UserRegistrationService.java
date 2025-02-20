
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.UserRegistrationException;

import java.util.concurrent.CompletableFuture;


public interface UserRegistrationService{
    void saveUser(UserRegistration registration) throws UserRegistrationException;

    CompletableFuture<String> autheticateUser(String email, String password) throws Exception;
}