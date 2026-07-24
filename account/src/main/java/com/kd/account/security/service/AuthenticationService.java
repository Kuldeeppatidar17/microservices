package com.kd.account.security.service;

import com.kd.account.security.dto.LoginRequest;
import com.kd.account.security.dto.RegisterRequest;

public interface AuthenticationService {

    void register(RegisterRequest request);

    void login(LoginRequest request);
}
