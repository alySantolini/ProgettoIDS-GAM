package it.unicam.progettoidsgam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class CuratoreController {

    @Autowired
    private CuratoreService curatoreService;

    public CuratoreController(CuratoreService curatoreService) {
        this.curatoreService = curatoreService;
        salvaCuratore();
    }
/*
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = contributoreService.authenticate(username, password);
        if (authenticated) {
            return new ResponseEntity<>("Login effettuato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenziali non valide", HttpStatus.UNAUTHORIZED);
        }
    }
    */

    @PostMapping("/salva-curatore")
    public ResponseEntity<String> salvaCuratore() {
        curatoreService.salva();
        return ResponseEntity.ok("Contributore salvato con successo!");
    }


}

