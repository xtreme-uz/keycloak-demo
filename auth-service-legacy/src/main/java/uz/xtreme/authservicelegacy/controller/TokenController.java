package uz.xtreme.authservicelegacy.controller;

import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import uz.xtreme.authservicelegacy.KeycloakClient;

@RestController
@RequiredArgsConstructor
public class TokenController {
    private final KeycloakClient keyCloakClient;

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity handleAuthNotFoundException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/validate")
    @PreAuthorize("hasRoles('MY_APP_USER', 'MY_APP_ADMIN')")
    public ResponseEntity validate() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<AccessTokenResponse> refresh(@RequestHeader("refresh-token") String refreshToken) {
        return ResponseEntity.ok(keyCloakClient.refreshToken(refreshToken));
    }
}
