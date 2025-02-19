package com.maybanktask.user_management.datafeed;

import com.maybanktask.user_management.dao.User;
import com.maybanktask.user_management.repository.UserRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeederRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeederRunner.class);


    @Value("${datafeed.name}")
    private String name;
    @Value("${datafeed.age}")
    private int age;
    @Value("${datafeed.password}")
    private String password;
    @Value("${datafeed.email}")
    private String email;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));

            try {

                userRepository.save(user);

            }catch(DataAccessException dae){
                logger.error("Error while feeding data into db due to : {}", ExceptionUtils.getStackTrace(dae));
            }
        }
    }
}
