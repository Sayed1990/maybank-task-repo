<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/repository/DataSourceRepository.java
package com.maybanktask.book_management.repository;

import com.maybanktask.book_management.DAO.Booksource;
========
<<<<<<< HEAD
package com.maybanktask.user_management.repository;

import com.maybanktask.user_management.dao.Booksource;
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/repository/DataSourceRepository.java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends JpaRepository<Booksource,Long> {
    @Query("SELECT d FROM Booksource d WHERE d.customerId = :customerId")
    Page<Booksource> getByCustomerId(String customerId, Pageable pageable);
}
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/repository/DataSourceRepository.java
========
=======
package com.maybanktask.user_management.repository;

import com.maybanktask.user_management.dao.Booksource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends JpaRepository<Booksource,Long> {
    @Query("SELECT d FROM Booksource d WHERE d.customerId = :customerId")
    Page<Booksource> getByCustomerId(String customerId, Pageable pageable);
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/repository/DataSourceRepository.java
