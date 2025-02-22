package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.exception.DataSourceException;
import com.maybanktask.user_management.serializer.CustomPage;
import org.springframework.data.domain.Page;

public interface DataSourceService {

    void save(BooksourceDto bookDto);

    Page<Booksource> getAllData(int pageNo, int pageSize);

    CustomPage<Booksource> getById(int pageNo, int pageSize, String customerId);

    void deleteData(String id);

    void updateById(String id, BooksourceDto booksourceDto) throws DataSourceException;
}