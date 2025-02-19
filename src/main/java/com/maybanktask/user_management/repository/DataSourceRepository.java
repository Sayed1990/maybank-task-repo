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
