package com.maybanktask.user_management.service;

import java.io.IOException;
import java.util.List;

public interface PublicApiService {
    List<String> getDataByRestTemplate();

    List<String> getDataByProducerTemplate() throws IOException;
}
