package com.maybanktask.user_management.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.serializer.CustomPage;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface DataIntegrationService {

    CompletableFuture<List<Object>> sendToBookServiceSave(BooksourceDto booksourceDto) throws JsonProcessingException;

    CustomPage<Object> getAllData(int pageNo, int pageSize);

    CustomPage<Object> getById(int pageNo, int pageSize, String customerId);

    void deleteData(String id);

    void updateById(String id,BooksourceDto booksourceDto);
}
