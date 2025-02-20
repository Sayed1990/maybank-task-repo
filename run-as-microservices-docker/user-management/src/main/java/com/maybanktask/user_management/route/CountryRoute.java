package com.maybanktask.user_management.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maybanktask.user_management.utils.RouteConstant.ROUTE_ID_DYNAMIC_API;

@Component
public class CountryRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().component("restlet").bindingMode(RestBindingMode.json);

        from(ROUTE_ID_DYNAMIC_API)
                .log("Using URL from header: ${header.url}")
                .toD("${header.url}")
                .process(exchange -> {
                    Object response = exchange.getIn().getBody(Object.class);
                    exchange.getIn().setBody(response);
                });
    }
}

