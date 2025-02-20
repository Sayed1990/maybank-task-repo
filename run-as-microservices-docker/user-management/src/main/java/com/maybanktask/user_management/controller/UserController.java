package com.maybanktask.user_management.controller;

import com.maybanktask.user_management.dto.LoginResponsePayload;
import com.maybanktask.user_management.dto.UserRegistration;
import com.maybanktask.user_management.exception.DataSourceException;
import com.maybanktask.user_management.exception.EmailFormatException;
import com.maybanktask.user_management.exception.UserRegistrationException;
import com.maybanktask.user_management.service.UserRegistrationService;
import com.maybanktask.user_management.utils.CommonConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@CrossOrigin(origins = "${frontendURL}")
@Tag(name = "UserController", description = "User management APIS")
@RestController
@RequestMapping(CommonConstants.USER_MAINPAGE)
@Validated
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRegistrationService userRegistrationService;

    @Operation(summary = "register new user into db", description = "enrolling user into db", tags = {"User", "post"})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}), @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}), @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping(CommonConstants.USER_REGISTER)
    public ResponseEntity<Boolean> registerUser(@RequestBody UserRegistration registration) throws UserRegistrationException, EmailFormatException, DataSourceException {

        userRegistrationService.saveUser(registration);

        logger.debug("successfully saved user!!");

        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }

    /**
     * This API handles the JWT token and aalong authentication and authorization for user
     * token will be generated and shared back in response
     */
    @Operation(summary = "login user", description = "creating token for successful login and the token will be used alongside the request", tags = {"User", "post"})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}), @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}), @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping(CommonConstants.USER_LOGIN)
    public ResponseEntity<LoginResponsePayload> login(@RequestParam String email, @RequestParam String password) throws Exception {

        CompletableFuture<String> isAuthenticated = userRegistrationService.autheticateUser(email, password);
        boolean isResponseSuccess = StringUtils.isNotBlank(isAuthenticated.get());

        if (!isResponseSuccess) logger.error("user authetication failed!!");
        else logger.debug("user is authenticated");

        return new ResponseEntity<>(new LoginResponsePayload(isAuthenticated.get(), isResponseSuccess ? "success" : "Bad Request"), HttpStatusCode.valueOf(isResponseSuccess ? 200 : 400));
    }


}
