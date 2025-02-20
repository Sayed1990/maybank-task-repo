<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/repository/UserRepository.java
========
<<<<<<< HEAD
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/repository/UserRepository.java
package com.maybanktask.user_management.repository;

import com.maybanktask.user_management.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);

    long count();

}
<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/repository/UserRepository.java
========
=======
package com.maybanktask.user_management.repository;

import com.maybanktask.user_management.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);

    long count();

}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/repository/UserRepository.java
