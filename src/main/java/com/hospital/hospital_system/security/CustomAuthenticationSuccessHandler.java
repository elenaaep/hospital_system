package com.hospital.hospital_system.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        response.sendRedirect(targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        boolean isDoctor = authentication.getAuthorities().contains(new SimpleGrantedAuthority("Doctor"));
        boolean isAsistent = authentication.getAuthorities().contains(new SimpleGrantedAuthority("Asistent"));
        boolean isAdmin = authentication.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        boolean isPacient = authentication.getAuthorities().contains(new SimpleGrantedAuthority("Pacient"));

        if (isDoctor) {
            return "/doctor";
        } else if (isAsistent) {
            return "/asistent";
        } else if (isAdmin) {
            return "/admin";
        } else if (isPacient) {
            return "/pacient";
        } else {
            return "/login?error=true";
        }
    }


}
