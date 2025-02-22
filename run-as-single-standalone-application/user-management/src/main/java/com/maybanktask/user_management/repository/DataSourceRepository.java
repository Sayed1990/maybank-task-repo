package com.maybanktask.user_management.repository;

import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.serializer.CustomPage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends JpaRepository<Booksource, Long> {
    @Query("SELECT d FROM Booksource d WHERE d.customerId = :customerId")
    CustomPage<Booksource> getByCustomerId(String customerId, Pageable pageable);
}