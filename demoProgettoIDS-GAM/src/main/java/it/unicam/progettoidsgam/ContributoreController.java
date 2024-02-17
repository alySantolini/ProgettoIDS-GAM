package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class ContributoreController {


    private ContributoreService contributoreService;
    @Autowired
    public ContributoreController(ContributoreService contributoreService) {
        this.contributoreService = contributoreService;
        salvaContributore();
    }

 /*  @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = contributoreService.authenticate(username, password);
        if (authenticated) {
            return new ResponseEntity<>("Login effettuato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenziali non valide", HttpStatus.UNAUTHORIZED);
        }
    }
*/

    @PostMapping("/salva-contributore")
    public ResponseEntity<String> salvaContributore() {
        contributoreService.salvaContributoreIniziale();
        return ResponseEntity.ok("Contributore salvato con successo!");
    }
    @PostMapping("/creaContributore")
    public ResponseEntity<Object> addContributore(@RequestBody Contributore contributore) {
        try {
            // Aggiungi il contributore nel database
            Contributore newContributore = contributoreService.addNewContributore(contributore);


            return new ResponseEntity<>(newContributore, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
