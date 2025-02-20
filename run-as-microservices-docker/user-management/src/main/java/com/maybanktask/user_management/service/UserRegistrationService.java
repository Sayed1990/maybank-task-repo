<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/service/UserRegistrationService.java
========
<<<<<<< HEAD
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/UserRegistrationService.java
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.UserRegistrationException;

import java.util.concurrent.CompletableFuture;


public interface UserRegistrationService{
    void saveUser(UserRegistration registration) throws UserRegistrationException;

    CompletableFuture<String> autheticateUser(String email, String password) throws Exception;
}
<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/service/UserRegistrationService.java
========
=======
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.UserRegistrationException;

import java.util.concurrent.CompletableFuture;


public interface UserRegistrationService{
    void saveUser(UserRegistration registration) throws UserRegistrationException;

    CompletableFuture<String> autheticateUser(String email, String password) throws Exception;
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/UserRegistrationService.java
