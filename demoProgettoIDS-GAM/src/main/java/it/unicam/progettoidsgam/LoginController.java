package it.unicam.progettoidsgam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class LoginController {

    private final LoginService authenticationService;

    @Autowired
    public LoginController(LoginService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = authenticationService.authenticate(username, password);
        if (authenticated) {
            return new ResponseEntity<>("Login effettuato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenziali non valide", HttpStatus.UNAUTHORIZED);
        }
    }
}