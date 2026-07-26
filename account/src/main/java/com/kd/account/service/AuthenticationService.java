package com.kd.account.service;

import com.kd.account.security.dto.AuthenticationResponse;
import com.kd.account.security.dto.LoginRequest;
import com.kd.account.security.dto.RegisterRequest;

public interface AuthenticationService {

    void register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}
