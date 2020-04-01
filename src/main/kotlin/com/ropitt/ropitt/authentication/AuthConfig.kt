package com.ropitt.ropitt.authentication

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer

@Profile("dev", "pro")
@EnableAuthorizationServer
@Configuration
class AuthConfig