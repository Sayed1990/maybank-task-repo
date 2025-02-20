package com.maybanktask.user_management.commonconfig;

import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.maybanktask.user_management.serializer.CustomPage;
import com.maybanktask.user_management.serializer.CustomPageDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.getFactory().setStreamWriteConstraints(
                StreamWriteConstraints.builder().maxNestingDepth(2000).build());

        SimpleModule module = new SimpleModule();
        module.addDeserializer(CustomPage.class, new CustomPageDeserializer<>());
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
