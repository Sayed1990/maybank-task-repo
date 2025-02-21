package com.maybanktask.book_management.service;

import com.maybanktask.book_management.DAO.Booksource;
import com.maybanktask.book_management.dto.BooksourceDto;
import com.maybanktask.book_management.exception.DataSourceException;
import org.springframework.data.domain.Page;

public interface DataSourceService {

    void save(BooksourceDto bookDto);

    Page<Booksource> getAllData(int pageNo, int pageSize);

    Page<Booksource> getById(int pageNo, int pageSize, String customerId);

    void deleteData(String id);

    void updateById(String id, BooksourceDto booksourceDto) throws DataSourceException;
}