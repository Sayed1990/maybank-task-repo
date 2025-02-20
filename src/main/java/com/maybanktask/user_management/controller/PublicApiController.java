<<<<<<< HEAD
package com.maybanktask.user_management.controller;


import com.maybanktask.user_management.service.PublicApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "PublicApiController", description = "Public APIS")
@RestController
@RequestMapping("/public")
@Validated
public class PublicApiController {
    private static final Logger logger = LoggerFactory.getLogger(PublicApiController.class);

    @Autowired
    private PublicApiService publicApiService;

    @Operation(summary = "Fetch data from Third Party Api by rest template", description = "retrieving data from Third party", tags = {"Public", "post"})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}), @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}), @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/get/by/rt")
    public ResponseEntity<?> getListOfCountryByRest() {

        List<String> listOfData=publicApiService.getDataByRestTemplate();

        logger.debug("data retrieved from third party api using rest template:{}",listOfData);

        return new ResponseEntity<>(listOfData, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Fetch data from Third Party Api by rest template", description = "retrieving data from Third party", tags = {"Public", "post"})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}), @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}), @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/get/by/pt")
    public ResponseEntity<?> getListOfCountryByCamel() throws IOException {

        List<String> listOfData=publicApiService.getDataByProducerTemplate();

        logger.debug("data retrieved from third party api using camel:{}",listOfData);

        return new ResponseEntity<>(listOfData, HttpStatusCode.valueOf(200));
    }
}
=======
package com.maybanktask.user_management.controller;


import com.maybanktask.user_management.service.PublicApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "PublicApiController", description = "Public APIS")
@RestController
@RequestMapping("/public")
@Validated
public class PublicApiController {
    private static final Logger logger = LoggerFactory.getLogger(PublicApiController.class);

    @Autowired
    private PublicApiService publicApiService;

    @Operation(summary = "Fetch data from Third Party Api by rest template", description = "retrieving data from Third party", tags = {"Public", "post"})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}), @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}), @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/get/by/rt")
    public ResponseEntity<?> getListOfCountryByRest() {

        List<String> listOfData=publicApiService.getDataByRestTemplate();

        logger.debug("data retrieved from third party api using rest template:{}",listOfData);

        return new ResponseEntity<>(listOfData, HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Fetch data from Third Party Api by rest template", description = "retrieving data from Third party", tags = {"Public", "post"})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}), @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}), @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/get/by/pt")
    public ResponseEntity<?> getListOfCountryByCamel() throws IOException {

        List<String> listOfData=publicApiService.getDataByProducerTemplate();

        logger.debug("data retrieved from third party api using camel:{}",listOfData);

        return new ResponseEntity<>(listOfData, HttpStatusCode.valueOf(200));
    }
}
>>>>>>> origin/main
