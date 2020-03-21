package com.example.demo.controller

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/user")
@EnableResourceServer
class UserController {

    @GetMapping
    fun getUsers(): String {
        return "user list"
    }
}