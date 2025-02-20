<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/commonconfig/JacksonConfig.java
package com.maybanktask.book_management.commonconfig;
========
<<<<<<< HEAD
package com.maybanktask.user_management.commonconfig;
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/commonconfig/JacksonConfig.java

import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/commonconfig/JacksonConfig.java
        objectMapper.disable(SerializationFeature.FAIL_ON_SELF_REFERENCES);
========
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/commonconfig/JacksonConfig.java
        objectMapper.getFactory().setStreamWriteConstraints(
                StreamWriteConstraints.builder().maxNestingDepth(2000).build());
        return objectMapper;
    }
}
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/commonconfig/JacksonConfig.java
========
=======
package com.maybanktask.user_management.commonconfig;

import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        return objectMapper;
    }
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/commonconfig/JacksonConfig.java
