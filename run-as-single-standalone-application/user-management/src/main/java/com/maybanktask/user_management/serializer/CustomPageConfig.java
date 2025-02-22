package com.maybanktask.user_management.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomPageConfig {

    public void customizeObjectMapper(ObjectMapper objectMapper) {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(CustomPage.class, new CustomPageDeserializer<>());
        objectMapper.registerModule(module);
    }
}

