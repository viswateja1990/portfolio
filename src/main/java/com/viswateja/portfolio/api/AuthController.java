package com.viswateja.portfolio.api;

import com.viswateja.portfolio.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
public class AuthController implements TokenApi {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<String> getToken(@RequestParam String username, @RequestParam String password) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            UserDetails user = (UserDetails) authentication.getPrincipal();
            return new ResponseEntity<>(jwtUtil.generateToken(user), HttpStatus.OK);
        } catch (AuthenticationException ex) {
            return new ResponseEntity<>("Invalid Username and Password", HttpStatus.BAD_REQUEST);
        }

    }
}
