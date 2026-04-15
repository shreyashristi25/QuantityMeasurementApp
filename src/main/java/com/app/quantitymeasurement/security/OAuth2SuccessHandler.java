package com.app.quantitymeasurement.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        String username = authentication.getName();
        String token = jwtUtil.generateToken(username);

        // Clear authentication attributes to avoid session issues
        clearAuthenticationAttributes(request);

        // Redirect to Angular frontend with the token in the query parameter
        // Make sure the port (4300) matches your Angular dev server
        String frontendRedirectUrl = "http://localhost:4300/auth/callback?token=" + token;
        getRedirectStrategy().sendRedirect(request, response, frontendRedirectUrl);
    }
}