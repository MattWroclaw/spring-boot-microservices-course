package com.appsdeveloperblog.photoapp.api.users.ui.controllers;

import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserRequestModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port = " + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid  @RequestBody  CreateUserRequestModel userDetails) {
        return "Create user was called";
    }
}
