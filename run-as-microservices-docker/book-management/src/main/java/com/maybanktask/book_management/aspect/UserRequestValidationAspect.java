package com.maybanktask.book_management.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserRequestValidationAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserRequestValidationAspect.class);

    @Pointcut("execution(* com.maybanktask.user_management.controller.UserController.*(..))")
    public void controllerMethods() {}

    /*@Before("controllerMethods() && args(registration,..)")
    public void validateRegisterUserRequest(UserRegistration registration) throws Exception {

        logger.info("Request details are : {}",registration);

        validateInput(registration);

        logger.info("Registration validation successful!");
    }

    @Before("controllerMethods() && args(email, password,..)")
    public void validateLoginRequest(String email, String password) throws Exception {
        logger.debug("username detail is : {}",email); // password should never be printed

        validateInput(List.of(email, password));

        logger.info("Login validation successful!");
    }*/
}
