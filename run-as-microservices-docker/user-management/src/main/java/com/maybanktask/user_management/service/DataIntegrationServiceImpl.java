package com.maybanktask.user_management.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maybanktask.user_management.client.BookServiceFeignClient;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.serializer.CustomPage;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DataIntegrationServiceImpl implements DataIntegrationService{

    @Value("${spring.kafka.topics}")
    private String kafkaTopic;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    BookServiceFeignClient bookServiceFeignClient;

    /**
     * This is for sample only because in reality we do not use kafka for just a simple storing value services
     * unless if we need to implement a distributed service management using pattern like saga or circuit breaker
     * to monitor every services for failure.
     * @param booksourceDto
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public CompletableFuture<List<Object>> sendToBookServiceSave(BooksourceDto booksourceDto) throws JsonProcessingException {
        List<Object> resultList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        String payloadConverted = objectMapper.writeValueAsString(booksourceDto);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafkaTopic, payloadConverted);

        return future.thenApply(result -> {
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "Message sent successfully!");
            successResponse.put("offset", result.getRecordMetadata().offset());
            successResponse.put("topic", result.getRecordMetadata().topic());

            resultList.add(successResponse);
            return resultList;
        }).exceptionally(ex -> {
            Map<String, Object> failureResponse = new HashMap<>();
            failureResponse.put("status", "failure");
            failureResponse.put("error", ex.getMessage());
            resultList.add(failureResponse);
            return resultList;
        });
    }

    /**
     * This service does not need to be transacational so we just execyte it without transaction by
     * overrideing the existing required above which is by default and it will join into the existing
     * transaction if present otherwise will create a new
     *
     * we do not have any service to declare as required_new because we do not want to suspend any existing
     * transactions while doing db operations as it is risky
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public CustomPage<Object> getAllData(int pageNo, int pageSize) {
        CustomPage<Object> pages=bookServiceFeignClient.getListOfBookByPages(pageNo, pageSize);
        return pages;
    }

    @Override
    public CustomPage<Object> getById(int pageNo, int pageSize, String customerId) {
        return bookServiceFeignClient.getById(pageNo,pageSize, customerId);
    }

    @Override
    public void deleteData(String id) {
        bookServiceFeignClient.deleteById(id);
    }

    @Override
    public void updateById(String id, BooksourceDto booksourceDto) {
        bookServiceFeignClient.updateById(id,booksourceDto);
    }

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(kafkaTopic,3,(short)1);
    }
}
