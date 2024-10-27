package com.appsdeveloperblog.photoapp.api.account.ui.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/account")
public class AccountControllers {

    @GetMapping(path = "/status/check")
    public String check() {
        return "ok";
    }
}
