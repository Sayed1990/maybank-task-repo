<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/service/DataSourceService.java
package com.maybanktask.book_management.service;

import com.maybanktask.book_management.DAO.Booksource;
import com.maybanktask.book_management.dto.BooksourceDto;
========
<<<<<<< HEAD
package com.maybanktask.user_management.service;

import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dto.BooksourceDto;
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/DataSourceService.java
import org.springframework.data.domain.Page;

public interface DataSourceService{

    void save(BooksourceDto bookDto);

    Page<Booksource> getAllData(int pageNo, int pageSize);

    Page<Booksource> getById(int pageNo, int pageSize, String customerId);

    void deleteData(String id);

    void updateById(String id, BooksourceDto booksourceDto);
}
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/service/DataSourceService.java
========
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
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/DataSourceService.java
