package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.LoginDto;
import com.hospital.hospital_system.dto.RegisterDto;
import com.hospital.hospital_system.models.User;
import com.hospital.hospital_system.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Valid
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if(userRepository.existsByUname(registerDto.getUsername())){
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        User user=new User();
        user.setUname(registerDto.getUsername());
        user.setParola(passwordEncoder.encode((registerDto.getPassword())));
        userRepository.save(user);
        return new ResponseEntity<>("User registred succes!", HttpStatus.OK);
    }

    @Valid
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(), loginDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(authToken);

            User user = userRepository.findByUname(loginDto.getUsername())
                    .orElseThrow(() -> new BadCredentialsException("Invalid username or password!"));

            boolean isPasswordMatching = passwordEncoder.matches(loginDto.getPassword(), user.getParola());

            System.out.println("Parola introdusă este corectă: " + isPasswordMatching);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return new ResponseEntity<>("Authentication Successful!", HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Invalid username or password!", HttpStatus.UNAUTHORIZED);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Authentication failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
