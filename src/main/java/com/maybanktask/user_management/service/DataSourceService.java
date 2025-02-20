<<<<<<< HEAD
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dto.BooksourceDto;
import org.springframework.data.domain.Page;

public interface DataSourceService{

    void save(BooksourceDto bookDto);

    Page<Booksource> getAllData(int pageNo, int pageSize);

    Page<Booksource> getById(int pageNo, int pageSize, String customerId);

    void deleteData(String id);

    void updateById(String id, BooksourceDto booksourceDto);
}
=======
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dto.BooksourceDto;
import org.springframework.data.domain.Page;

public interface DataSourceService{

    void save(BooksourceDto bookDto);

    Page<Booksource> getAllData(int pageNo, int pageSize);

    Page<Booksource> getById(int pageNo, int pageSize, String customerId);

    void deleteData(String id);

    void updateById(String id, BooksourceDto booksourceDto);
}
>>>>>>> origin/main
