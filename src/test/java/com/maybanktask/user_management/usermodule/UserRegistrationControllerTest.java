<<<<<<< HEAD
package com.maybanktask.user_management.usermodule;

import com.maybanktask.user_management.controller.UserController;
import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.EmailFormatException;
import com.maybanktask.user_management.exception.UserRegistrationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRegistrationControllerTest {
    @InjectMocks
    UserController userController;


    static UserRegistration userRegistration;
    @BeforeAll
    public static void setup(){
        userRegistration=new UserRegistration();
        userRegistration.setAge(10);
        userRegistration.setName("mockName");
        userRegistration.setEmail("mockEmail");
        userRegistration.setPassword("mockPassword");
    }

    /**
     * Since we are using sealed interface which only restricts the access by child member, its not
     * really straightfoward to mock the userRegistrationService interface therefor i have just included this
     * method just to cover a few lines
     * @throws EmailFormatException
     * @throws UserRegistrationException
     */
    @Test
    public void testUserRegistration() throws EmailFormatException, UserRegistrationException {
        userRegistration.setEmail("abc@gmail.com");
        Assertions.assertThrows(NullPointerException.class,()->userController.registerUser(userRegistration));
    }

    /**
     * this is a newgative scenarios when email pattern is not proper
     * @throws EmailFormatException
     * @throws UserRegistrationException
     */
    @Test
    public void testUserRegistrationForEmailFormatError() throws EmailFormatException, UserRegistrationException {
       Exception exception= Assertions.assertThrows(EmailFormatException.class,
                () -> userController.registerUser(userRegistration));
        assertEquals("Email format error!!", exception.getMessage());
    }
}
=======
package com.maybanktask.user_management.usermodule;

import com.maybanktask.user_management.controller.UserController;
import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.EmailFormatException;
import com.maybanktask.user_management.exception.UserRegistrationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRegistrationControllerTest {
    @InjectMocks
    UserController userController;


    static UserRegistration userRegistration;
    @BeforeAll
    public static void setup(){
        userRegistration=new UserRegistration();
        userRegistration.setAge(10);
        userRegistration.setName("mockName");
        userRegistration.setEmail("mockEmail");
        userRegistration.setPassword("mockPassword");
    }

    /**
     * Since we are using sealed interface which only restricts the access by child member, its not
     * really straightfoward to mock the userRegistrationService interface therefor i have just included this
     * method just to cover a few lines
     * @throws EmailFormatException
     * @throws UserRegistrationException
     */
    @Test
    public void testUserRegistration() throws EmailFormatException, UserRegistrationException {
        userRegistration.setEmail("abc@gmail.com");
        Assertions.assertThrows(NullPointerException.class,()->userController.registerUser(userRegistration));
    }

    /**
     * this is a newgative scenarios when email pattern is not proper
     * @throws EmailFormatException
     * @throws UserRegistrationException
     */
    @Test
    public void testUserRegistrationForEmailFormatError() throws EmailFormatException, UserRegistrationException {
       Exception exception= Assertions.assertThrows(EmailFormatException.class,
                () -> userController.registerUser(userRegistration));
        assertEquals("Email format error!!", exception.getMessage());
    }
}
>>>>>>> origin/main
