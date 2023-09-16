package uz.xtreme.authservicelegacy.controller;

import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.xtreme.authservicelegacy.AuthRequestDto;
import uz.xtreme.authservicelegacy.KeycloakClient;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class AuthenticateController {

    private final KeycloakClient keyCloakClient;

    @PostMapping
    public ResponseEntity<AccessTokenResponse> authenticate(@RequestBody AuthRequestDto request) {
        return ResponseEntity.ok(keyCloakClient.authenticate(request));
    }

}
