package com.ferafln.finance.service;

import com.ferafln.finance.controller.dto.auth.AuthenticationRequest;
import com.ferafln.finance.controller.dto.auth.AuthenticationResponse;
import com.ferafln.finance.controller.dto.auth.RegisterRequest;
import com.ferafln.finance.exception.ForbiddenException;
import com.ferafln.finance.exception.UniqueConstraintException;
import com.ferafln.finance.message.I18n;
import com.ferafln.finance.message.Message;
import com.ferafln.finance.model.User;
import com.ferafln.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = request.mapToUser(passwordEncoder);
        repository
                .findByUsername(request.getUsername())
                .ifPresent(u-> {
                    throw new UniqueConstraintException(Message.UNIQUE_USERNAME);
                });
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        }catch (AuthenticationException e){
            throw new ForbiddenException();
        }
        var user = findByUsername(request.getUsername());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public User findByUsername(String username){
        return repository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found!"));
    }
}
