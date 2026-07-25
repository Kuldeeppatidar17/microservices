package com.kd.account.controller;

import com.kd.account.dtos.ApiResponse;
import com.kd.account.dtos.ApiResponseUtil;
import com.kd.account.security.dto.LoginRequest;
import com.kd.account.security.dto.RegisterRequest;
import com.kd.account.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@Valid @RequestBody RegisterRequest request){
        log.info("Enter into the authentication register controller:");
        authenticationService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseUtil.success(HttpStatus.CREATED.value(),"User registered successfully."));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Void>> login(@Valid @RequestBody LoginRequest request){
        log.info("Enter into the login authentication controller !");
        authenticationService.login(request);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseUtil.success(HttpStatus.OK.value(), "User logged in successfully !"));
    }
}
