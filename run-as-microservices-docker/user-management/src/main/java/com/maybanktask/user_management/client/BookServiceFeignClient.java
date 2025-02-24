package com.maybanktask.user_management.client;

import com.maybanktask.user_management.commonconfig.FeignConfig;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.serializer.CustomPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("${micro-service.book-service.name}")
public interface BookServiceFeignClient {

    @GetMapping("${micro-service.book-service.get-book-by-page-url}")
    CustomPage<Object> getListOfBookByPages(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    @GetMapping("${micro-service.book-service.get-by-cust-id-url}")
    CustomPage<Object> getById(@RequestParam("pageNo")int pageNo, @RequestParam("pageSize") int pageSize, @PathVariable("customerId") String customerId);

    @DeleteMapping("${micro-service.book-service.delete-by-id-url}")
    void deleteById(@PathVariable("customerId") String id);

    @PutMapping("${micro-service.book-service.update-by-id-url}")
    void updateById(@PathVariable("customerId") String id, @RequestBody BooksourceDto booksourceDto);
}
