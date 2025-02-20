package com.maybanktask.user_management.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.exception.DataSourceException;
import com.maybanktask.user_management.exception.EmailFormatException;
import com.maybanktask.user_management.serializer.CustomPage;
import com.maybanktask.user_management.service.DataIntegrationService;
import com.maybanktask.user_management.utils.CommonConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.maybanktask.user_management.utils.InputValidator.validateInput;

@CrossOrigin(origins = "${frontendURL}")
@Tag(name = "DataIntegrationController", description = "This Module handle the integration to other exposed microservices like data-management-microservice")
@RestController
@RequestMapping(CommonConstants.DATA_LANDING_PAGE)
@Validated
public class DataIntegrationController {

    private static final Logger logger = LoggerFactory.getLogger(DataIntegrationController.class);


    @Autowired
    DataIntegrationService dataIntegrationService;


    @Operation(
            summary = "saving new data",
            description = "adding data details into DB",
            tags = {"Data", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping(CommonConstants.SAVE_DATA)
    public ResponseEntity<String> saveData(@RequestBody BooksourceDto booksourceDto) throws DataSourceException, EmailFormatException, DataSourceException, JsonProcessingException {

        validateInput(booksourceDto);

        dataIntegrationService.sendToBookServiceSave(booksourceDto);

        return new ResponseEntity<>("success", HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "retrieving all data details",
            description = "getting data details from DB",
            tags = {"Data", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping(CommonConstants.RETRIEVE_ALL_DATA)
    public ResponseEntity<?> retrieveAllData(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        CustomPage<Object> getAllData = dataIntegrationService.getAllData(pageNo, pageSize);
        logger.debug("get list of all data:{}", getAllData);
        return new ResponseEntity<>(getAllData, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "retrieving data by customer id details",
            description = "getting data details from DB",
            tags = {"Data", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping(CommonConstants.RETRIEVE_BY_CUSTOMER_ID)
    public ResponseEntity<?> retrieveByCustomerID(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize, @PathVariable String customerId) {
        CustomPage<Object> getAllData = dataIntegrationService.getById(pageNo, pageSize, customerId);
        logger.debug("get list of data by customer id:{}", getAllData);
        return new ResponseEntity<>(getAllData, HttpStatusCode.valueOf(200));
    }


    @Operation(
            summary = "delete by id",
            description = "delete data details from DB",
            tags = {"Data", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping(CommonConstants.DELETE)
    public ResponseEntity<Boolean> deleteByDescription(@PathVariable String id) {
        dataIntegrationService.deleteData(id);
        logger.debug("deleting from DB");
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }

    @Operation(
            summary = "update by id",
            description = "update data details from DB",
            tags = {"Data", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PutMapping(CommonConstants.UPDATE)
    public ResponseEntity<Boolean> updateByDescription(@PathVariable String id, @RequestBody BooksourceDto booksourceDto) {
        dataIntegrationService.updateById(id,booksourceDto);
        logger.debug("updating to DB");
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }

}
