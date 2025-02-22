package com.maybanktask.bookmodule;

import com.maybanktask.user_management.controller.BookController;
import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.repository.DataSourceRepository;
import com.maybanktask.user_management.service.DataSourceService;
import com.maybanktask.user_management.service.DataSourceServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class BookControllerTest {

    @InjectMocks
    BookController controller;

    @Mock
    DataSourceRepository bookRepository;

    static Booksource book;

    static BooksourceDto bookDto;

    static DataSourceService bookService;
    static List<BooksourceDto> book_dto_list=null;
    static List<Booksource> book_list=null;


    @BeforeAll
    public static void setup(){
        book=new Booksource();
        bookDto=new BooksourceDto();
        book.setId(1L);
        bookService=new DataSourceServiceImpl();
        mock(DataSourceServiceImpl.class);

        book_dto_list=new ArrayList<>(List.of(bookDto));
        book_list=new ArrayList<>(List.of(book));

    }


}
