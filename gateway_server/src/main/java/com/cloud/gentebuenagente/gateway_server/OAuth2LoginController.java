package com.cloud.gentebuenagente.gateway_server;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Index controller.
 *
 * @author Rob Winch
 */
@Controller
public class OAuth2LoginController {

    @GetMapping("/")
    public ResponseEntity<String> getNombreCompleto(
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
            @AuthenticationPrincipal OAuth2User oauth2User
            ) {
        return ResponseEntity.ok(
            "user name: " + oauth2User.getName().toString() + 
            "client name: " + authorizedClient.getClientRegistration().getClientName().toString()
            + "user attributes" + oauth2User.getAttributes().toString()
            );
    }
}
