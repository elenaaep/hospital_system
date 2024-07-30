package com.hospital.hospital_system.security;

import com.hospital.hospital_system.models.User;
import com.hospital.hospital_system.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUname(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getUtip());
        return new org.springframework.security.core.userdetails.User(
                user.getUname(),
                user.getParola(), // BCrypt hashed password from DB
                Collections.singletonList(authority)
        );
    }
}
