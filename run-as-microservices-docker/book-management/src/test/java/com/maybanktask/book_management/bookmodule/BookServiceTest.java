package com.maybanktask.book_management.bookmodule;

import com.maybanktask.book_management.DAO.Booksource;
import com.maybanktask.book_management.dto.BooksourceDto;
import com.maybanktask.book_management.repository.DataSourceRepository;
import com.maybanktask.book_management.service.DataSourceServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Mock
    DataSourceRepository bookRepository;

    @InjectMocks
    DataSourceServiceImpl bookService;

    static Booksource book;

    static BooksourceDto bookDto;

    static List<BooksourceDto> book_dto_list=null;
    static List<Booksource> book_list=null;
    @BeforeAll
    public static void setup(){
        book=new Booksource();
        bookDto=new BooksourceDto();
        book.setId(1L);

        book_dto_list=new ArrayList<>(List.of(bookDto));
        book_list=new ArrayList<>(List.of(book));

    }

    @Test
    public void testBookRegister(){
        when(bookRepository.save(book)).thenReturn(book);
        bookService.save(bookDto);
    }

}
