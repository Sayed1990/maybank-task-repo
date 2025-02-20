<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/exception/UserControllerAdvice.java
========
<<<<<<< HEAD
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/exception/UserControllerAdvice.java
package com.maybanktask.user_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(EmailFormatException.class)
    public ResponseEntity<String> handleException(EmailFormatException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<String> handleUserRegistrationException(UserRegistrationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }
}
<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/exception/UserControllerAdvice.java
========
=======
package com.maybanktask.user_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(EmailFormatException.class)
    public ResponseEntity<String> handleException(EmailFormatException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<String> handleUserRegistrationException(UserRegistrationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/exception/UserControllerAdvice.java
