<<<<<<< HEAD
package com.maybanktask.user_management.controller;


import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.exception.DataSourceException;
import com.maybanktask.user_management.exception.EmailFormatException;
import com.maybanktask.user_management.service.DataSourceService;
import com.maybanktask.user_management.utils.CommonConstants;
import com.maybanktask.user_management.utils.InputValidator;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Data controller", description = "Data Management APIS")
@RestController
@RequestMapping(CommonConstants.LANDING_PAGE)
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    DataSourceService dataSourceService;

    @Operation(
            summary = "Register new book details",
            description = "adding book details into DB",
            tags = { "Book", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(CommonConstants.SAVE_DATA)
    public ResponseEntity<String> registerBook(@RequestBody BooksourceDto bookDto) throws EmailFormatException, DataSourceException {
        InputValidator.validateInput(bookDto);
        dataSourceService.save(bookDto);
        logger.debug("book saved successfully");
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
    public ResponseEntity<Page<Booksource>> retrieveAllData(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<Booksource> getAllData = dataSourceService.getAllData(pageNo, pageSize);
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
    public ResponseEntity<Page<Booksource>> retrieveByCustomerID(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize, @PathVariable String customerId) {
        Page<Booksource> getAllData = dataSourceService.getById(pageNo, pageSize, customerId);
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
        dataSourceService.deleteData(id);
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
        dataSourceService.updateById(id,booksourceDto);
        logger.debug("updating to DB");
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }


}
=======
package com.maybanktask.user_management.controller;


import com.maybanktask.user_management.dao.Booksource;
import com.maybanktask.user_management.dto.BooksourceDto;
import com.maybanktask.user_management.exception.DataSourceException;
import com.maybanktask.user_management.exception.EmailFormatException;
import com.maybanktask.user_management.service.DataSourceService;
import com.maybanktask.user_management.utils.CommonConstants;
import com.maybanktask.user_management.utils.InputValidator;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Data controller", description = "Data Management APIS")
@RestController
@RequestMapping(CommonConstants.LANDING_PAGE)
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    DataSourceService dataSourceService;

    @Operation(
            summary = "Register new book details",
            description = "adding book details into DB",
            tags = { "Book", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(CommonConstants.SAVE_DATA)
    public ResponseEntity<String> registerBook(@RequestBody BooksourceDto bookDto) throws EmailFormatException, DataSourceException {
        InputValidator.validateInput(bookDto);
        dataSourceService.save(bookDto);
        logger.debug("book saved successfully");
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
    public ResponseEntity<Page<Booksource>> retrieveAllData(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<Booksource> getAllData = dataSourceService.getAllData(pageNo, pageSize);
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
    public ResponseEntity<Page<Booksource>> retrieveByCustomerID(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize, @PathVariable String customerId) {
        Page<Booksource> getAllData = dataSourceService.getById(pageNo, pageSize, customerId);
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
        dataSourceService.deleteData(id);
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
        dataSourceService.updateById(id,booksourceDto);
        logger.debug("updating to DB");
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }


}
>>>>>>> origin/main
