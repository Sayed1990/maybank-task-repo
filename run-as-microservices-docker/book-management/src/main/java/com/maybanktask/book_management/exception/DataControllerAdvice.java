<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/exception/DataControllerAdvice.java
package com.maybanktask.book_management.exception;
========
<<<<<<< HEAD
package com.maybanktask.user_management.exception;
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/exception/DataControllerAdvice.java

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataControllerAdvice {

    @ExceptionHandler(DataSourceException.class)
    public ResponseEntity<String> handleException(DataSourceException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }
}
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/exception/DataControllerAdvice.java
========
=======
package com.maybanktask.user_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataControllerAdvice {

    @ExceptionHandler(DataSourceException.class)
    public ResponseEntity<String> handleException(DataSourceException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/exception/DataControllerAdvice.java
