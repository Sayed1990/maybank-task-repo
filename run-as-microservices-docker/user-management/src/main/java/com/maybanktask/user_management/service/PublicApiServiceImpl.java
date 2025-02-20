<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/service/PublicApiServiceImpl.java
========
<<<<<<< HEAD
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/PublicApiServiceImpl.java
package com.maybanktask.user_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.converter.stream.InputStreamCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.maybanktask.user_management.utils.RouteConstant.ROUTE_ID_DYNAMIC_API;

@Service
public class PublicApiServiceImpl implements PublicApiService {
    private static final Logger logger = LoggerFactory.getLogger(PublicApiServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Value("${third-party-url}")
    private String thirdPartyUrl;

    @Override
    public List<String> getDataByRestTemplate() {

        List<?> countries = restTemplate.getForObject(thirdPartyUrl, List.class);
        if (CollectionUtils.isEmpty(countries)) {
            return new ArrayList<>();
        }
        logger.info("Data response by rest emplate:{}", countries);
        return listOfCountriesCollection(countries);
    }


    @Override
    public List<String> getDataByProducerTemplate() throws IOException {

        InputStream inputStream = (InputStreamCache) producerTemplate.requestBodyAndHeader(ROUTE_ID_DYNAMIC_API, null, "url", thirdPartyUrl, Object.class);

        return extractCountryNames(inputStream);

    }

    private List<String> extractCountryNames(InputStream inputStreamCache) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<?> countries;

        countries = objectMapper.readValue(inputStreamCache, List.class);

        return listOfCountriesCollection(countries);
    }

    private List<String> listOfCountriesCollection(List<?> countries) {
        return countries.stream()
                .map(country -> {
                    @SuppressWarnings("unchecked")
                    var countryMap = (java.util.Map<String, Object>) country;
                    @SuppressWarnings("unchecked")
                    var nameMap = (java.util.Map<String, String>) countryMap.get("name");
                    return nameMap.get("common");
                })
                .collect(Collectors.toList());
    }
}
<<<<<<<< HEAD:run-as-microservices-docker/user-management/src/main/java/com/maybanktask/user_management/service/PublicApiServiceImpl.java
========
=======
package com.maybanktask.user_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.converter.stream.InputStreamCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.maybanktask.user_management.utils.RouteConstant.ROUTE_ID_DYNAMIC_API;

@Service
public class PublicApiServiceImpl implements PublicApiService {
    private static final Logger logger = LoggerFactory.getLogger(PublicApiServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Value("${third-party-url}")
    private String thirdPartyUrl;

    @Override
    public List<String> getDataByRestTemplate() {

        List<?> countries = restTemplate.getForObject(thirdPartyUrl, List.class);
        if (CollectionUtils.isEmpty(countries)) {
            return new ArrayList<>();
        }
        logger.info("Data response by rest emplate:{}", countries);
        return listOfCountriesCollection(countries);
    }


    @Override
    public List<String> getDataByProducerTemplate() throws IOException {

        InputStream inputStream = (InputStreamCache) producerTemplate.requestBodyAndHeader(ROUTE_ID_DYNAMIC_API, null, "url", thirdPartyUrl, Object.class);

        return extractCountryNames(inputStream);

    }

    private List<String> extractCountryNames(InputStream inputStreamCache) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<?> countries;

        countries = objectMapper.readValue(inputStreamCache, List.class);

        return listOfCountriesCollection(countries);
    }

    private List<String> listOfCountriesCollection(List<?> countries) {
        return countries.stream()
                .map(country -> {
                    @SuppressWarnings("unchecked")
                    var countryMap = (java.util.Map<String, Object>) country;
                    @SuppressWarnings("unchecked")
                    var nameMap = (java.util.Map<String, String>) countryMap.get("name");
                    return nameMap.get("common");
                })
                .collect(Collectors.toList());
    }
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/service/PublicApiServiceImpl.java
