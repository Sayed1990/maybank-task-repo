<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/aspect/UserRequestValidationAspect.java
========
<<<<<<< HEAD
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/aspect/UserRequestValidationAspect.java
package com.maybanktask.user_management.aspect;

import com.maybanktask.user_management.dto.UserRegistration;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maybanktask.user_management.utils.AspectConstant.*;
import static com.maybanktask.user_management.utils.InputValidator.validateInput;

@Aspect
@Component
public class UserRequestValidationAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserRequestValidationAspect.class);

    @Pointcut(USER_CONTROLLER_HOMEPATH)
    public void controllerMethods() {}

    @Before(REGISTER_USER_API_PATH)
    public void validateRegisterUserRequest(UserRegistration registration) throws Exception {

        logger.debug("Request details are : {}",registration);

        validateInput(registration);

        logger.info("Registration validation successful!");
    }

    @Before(VALIDATE_USER_LOGIN_PATH)
    public void validateLoginRequest(String email, String password) throws Exception {
        logger.debug("username detail is : {}",email); // password should never be printed

        validateInput(List.of(email, password));

        logger.info("Login validation successful!");
    }
}
<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/aspect/UserRequestValidationAspect.java
========
=======
package com.maybanktask.user_management.aspect;

import com.maybanktask.user_management.dto.UserRegistration;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maybanktask.user_management.utils.AspectConstant.*;
import static com.maybanktask.user_management.utils.InputValidator.validateInput;

@Aspect
@Component
public class UserRequestValidationAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserRequestValidationAspect.class);

    @Pointcut(USER_CONTROLLER_HOMEPATH)
    public void controllerMethods() {}

    @Before(REGISTER_USER_API_PATH)
    public void validateRegisterUserRequest(UserRegistration registration) throws Exception {

        logger.debug("Request details are : {}",registration);

        validateInput(registration);

        logger.info("Registration validation successful!");
    }

    @Before(VALIDATE_USER_LOGIN_PATH)
    public void validateLoginRequest(String email, String password) throws Exception {
        logger.debug("username detail is : {}",email); // password should never be printed

        validateInput(List.of(email, password));

        logger.info("Login validation successful!");
    }
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/aspect/UserRequestValidationAspect.java
