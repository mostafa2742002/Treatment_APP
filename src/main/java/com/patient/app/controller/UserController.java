package com.patient.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.patient.app.dto.UserDTO;
import com.patient.app.model.JwtResponse;
import com.patient.app.model.User;
import com.patient.app.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody @Valid UserDTO userDTO) {
        User user = userService.register(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // Todo : Invalid endpoint, authenticated endpoints shouldn't be redirected to
    // gh login page
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(@RequestBody UserDTO userDTO) {
        JwtResponse jwtResponse = userService.login(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
    }

    @PostMapping("/user/profile-picture")
    public ResponseEntity<String> saveCurrentUserProfilePicture(@RequestBody JsonNode user) {
        String email = user.get("email").asText();
        String image = user.get("image").asText();

        userService.saveProfileImage(email,image);
        return ResponseEntity.ok("image added");

    }

    @GetMapping("/user/profile-picture")
    public ResponseEntity<String> getCurrentUserProfilePicture() {
        String profilePicture = userService.getCurrentUserProfilePicture();
        return ResponseEntity.ok(profilePicture);
    }

    @GetMapping("/user/name")
    public ResponseEntity<String> getCurrentUserName() {
        String userName = userService.getCurrentUserName();
        return ResponseEntity.ok(userName);
    }

    @GetMapping("/user/email")
    public ResponseEntity<String> getCurrentUserEmail() {
        String email = userService.getCurrentUserEmail();
        return ResponseEntity.ok(email);
    }
}
