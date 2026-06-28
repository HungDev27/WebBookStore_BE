package com.hungjava.bookstore.service;

import com.hungjava.bookstore.dto.security.*;
import java.text.ParseException;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest request);
    MessageResponse activateAccount(String token);
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
    IntrospectResponse introspect(IntrospectRequest introspectRequest);
    void logout(LogoutRequest logoutRequest) throws ParseException;
}
