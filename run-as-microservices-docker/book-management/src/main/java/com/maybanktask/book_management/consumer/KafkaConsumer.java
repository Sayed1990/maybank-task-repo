package com.maybanktask.book_management.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maybanktask.book_management.dto.BooksourceDto;
import com.maybanktask.book_management.service.DataSourceService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    DataSourceService dataSourceService;

    @KafkaListener(topics = "${spring.kafka.topics}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String payload) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BooksourceDto booksourceDto = objectMapper.readValue(payload, BooksourceDto.class);
            logger.info("datasource values are : {}",booksourceDto);
            dataSourceService.save(booksourceDto);
        } catch (Exception e) {
            logger.error("Error occured during mapping Object due to:{}", ExceptionUtils.getStackTrace(e));
        }
    }
}
