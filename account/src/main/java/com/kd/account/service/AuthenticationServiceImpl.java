package com.kd.account.service;

import com.kd.account.exceptions.DuplicateResourceException;
import com.kd.account.security.dto.AuthenticationResponse;
import com.kd.account.security.dto.LoginRequest;
import com.kd.account.security.dto.RegisterRequest;
import com.kd.account.security.jwt.JwtService;
import com.kd.account.security.user.Role;
import com.kd.account.security.user.User;
import com.kd.account.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private static final String TOKEN_TYPE="Bearer";
    @Override
    public void register(RegisterRequest request) {

        if(userRepository.findByEmail(request.email()).isPresent()){
            throw new DuplicateResourceException("User Already Exists !!!");
        }

        User user=User.builder().
                fullName(request.fullName()).
                email(request.email()).
                password(passwordEncoder.encode(request.password())).
                role(Role.ROLE_USER).
                build();

        userRepository.save(user);
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {

        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(),request.password())
        );

        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token,TOKEN_TYPE);
    }
}
