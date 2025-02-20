<<<<<<< HEAD
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.User;
import com.maybanktask.user_management.commonconfig.JwtTokenUtil;
import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.UserRegistrationException;
import com.maybanktask.user_management.repository.UserRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private static final Logger logger= LoggerFactory.getLogger(UserRegistrationServiceImpl.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * This Api we used to store user into DB. If the user email exist then we will throw error
     * We use propagation as required so that if there is another transaction using the below method
     * then we can join on it instead of creating a new one unless there is no new
     *
     * By Default the propagation is REQUIRED however I just use it to let you know that i am going for
     * this approach
     * @param registration
     * @throws UserRegistrationException
     */
    @Override
    public void saveUser(UserRegistration registration) throws UserRegistrationException {

        User user=mapEntityFromDto(registration);
        logger.debug("user detail:{}", user);

        if(!isUserExist(user.getEmail())){
            logger.debug("user does not exist in DB so can proceed to register!!");
            try{
                userRepository.saveAndFlush(user);
            }catch(DataAccessException dae){
                logger.error("Data Access Error due to :{}", ExceptionUtils.getStackTrace(dae));
            }

        }else{
            logger.error("user email already exist in records!");
            throw new UserRegistrationException("Email already existed!");
        }


    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    private boolean isUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    /**
     * This method is used to autheticate user with db and token generated to be shared with user
     * The method is asynchronous is because we want the thread to be not locked and perforimg other tasks
     * too. If too nany requests calling this method in non asynchronous approach, that will lead the thread
     * to be consumed and locked until the response. so, using async is the best choice here
     *
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    @Async
    public CompletableFuture<String> autheticateUser(String email, String password) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );
            logger.debug("user is authenticated successfully");
        } catch (DisabledException e) {
            logger.error("user is authenticated");
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        final String token = jwtTokenUtil.generateToken(userDetails);
        logger.debug("user token :{}",token);// By right, this is confidential and should never be printed in logs.
        return CompletableFuture.completedFuture(token);
    }

    private User mapEntityFromDto(UserRegistration registration) {
        User user=new User();
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setName(registration.getName());
        user.setAge(registration.getAge());
        user.setEmail(registration.getEmail());
        return user;
    }
}
=======
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.User;
import com.maybanktask.user_management.commonconfig.JwtTokenUtil;
import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.UserRegistrationException;
import com.maybanktask.user_management.repository.UserRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private static final Logger logger= LoggerFactory.getLogger(UserRegistrationServiceImpl.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * This Api we used to store user into DB. If the user email exist then we will throw error
     * We use propagation as required so that if there is another transaction using the below method
     * then we can join on it instead of creating a new one unless there is no new
     *
     * By Default the propagation is REQUIRED however I just use it to let you know that i am going for
     * this approach
     * @param registration
     * @throws UserRegistrationException
     */
    @Override
    public void saveUser(UserRegistration registration) throws UserRegistrationException {

        User user=mapEntityFromDto(registration);
        logger.debug("user detail:{}", user);

        if(!isUserExist(user.getEmail())){
            logger.debug("user does not exist in DB so can proceed to register!!");
            try{
                userRepository.saveAndFlush(user);
            }catch(DataAccessException dae){
                logger.error("Data Access Error due to :{}", ExceptionUtils.getStackTrace(dae));
            }

        }else{
            logger.error("user email already exist in records!");
            throw new UserRegistrationException("Email already existed!");
        }


    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    private boolean isUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    /**
     * This method is used to autheticate user with db and token generated to be shared with user
     * The method is asynchronous is because we want the thread to be not locked and perforimg other tasks
     * too. If too nany requests calling this method in non asynchronous approach, that will lead the thread
     * to be consumed and locked until the response. so, using async is the best choice here
     *
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    @Async
    public CompletableFuture<String> autheticateUser(String email, String password) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );
            logger.debug("user is authenticated successfully");
        } catch (DisabledException e) {
            logger.error("user is authenticated");
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        final String token = jwtTokenUtil.generateToken(userDetails);
        logger.debug("user token :{}",token);// By right, this is confidential and should never be printed in logs.
        return CompletableFuture.completedFuture(token);
    }

    private User mapEntityFromDto(UserRegistration registration) {
        User user=new User();
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setName(registration.getName());
        user.setAge(registration.getAge());
        user.setEmail(registration.getEmail());
        return user;
    }
}
>>>>>>> origin/main
