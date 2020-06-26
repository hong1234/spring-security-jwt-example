package com.hong.demo.controller;

import com.hong.demo.util.JwtUtil;
import com.hong.demo.entity.AuthRequest;
import com.hong.demo.entity.RegisterRequest;
import com.hong.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.hong.demo.repository.UserRepository;

import javax.validation.Valid;

@RestController
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to jwt !!";
    }

    @GetMapping("/admin")
    public String welcomeAdmin() {
        return "Welcome to Admin !!";
    }

    @GetMapping("/admin/delete")
    public String welcomeAdminDel() {
        return "Welcome to Admin Delete !!";
    }

    @PostMapping("/register")
    public void signUp(@RequestBody @Valid RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUserName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setRole("ROLE_USER");
        repository.save(user);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
