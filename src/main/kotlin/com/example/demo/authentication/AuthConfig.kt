package com.example.demo.authentication

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@Profile("dev", "pro")
@EnableAuthorizationServer
@EnableResourceServer
@Configuration
class AuthConfig