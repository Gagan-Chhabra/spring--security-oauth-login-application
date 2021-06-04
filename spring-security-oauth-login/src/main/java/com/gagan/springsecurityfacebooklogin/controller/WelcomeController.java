package com.gagan.springsecurityfacebooklogin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.MessageFormat;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String fname, @RequestParam String lname , OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        if(oAuth2AuthenticationToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        var userEmail = oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
        var message =  MessageFormat.format("Welcome {0} {1} Your email is : {2}", fname, lname, userEmail);
        return ResponseEntity.ok(message);
    }
}
