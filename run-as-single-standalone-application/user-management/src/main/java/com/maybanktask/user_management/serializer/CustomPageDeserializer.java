package com.maybanktask.user_management.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public class CustomPageDeserializer<T> extends JsonDeserializer<CustomPage<T>> {

    @Override
    public CustomPage<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        JsonNode contentNode = node.get("content");
        List<T> content = p.getCodec().readValue(contentNode.traverse(), new TypeReference<>() {
        });

        JsonNode pageableNode = node.get("pageable");
        Pageable pageable = PageRequest.of(pageableNode.get("pageNumber").asInt(), pageableNode.get("pageSize").asInt());

        long total = node.get("totalElements").asLong();

        return new CustomPage<>(content, pageable, total);
    }
}
