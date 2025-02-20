package com.maybanktask.book_management.repository;

import com.maybanktask.book_management.DAO.Booksource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends JpaRepository<Booksource, Long> {
    @Query("SELECT d FROM Booksource d WHERE d.customerId = :customerId")
    Page<Booksource> getByCustomerId(String customerId, Pageable pageable);
}