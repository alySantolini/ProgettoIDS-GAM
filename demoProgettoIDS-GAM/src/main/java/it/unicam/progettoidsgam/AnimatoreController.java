/*package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class AnimatoreController {

    @Autowired
    private AnimatoreService animatoreService;

    public AnimatoreController(AnimatoreService animatoreService) {
        this.animatoreService = animatoreService;
        salvaAnimatore();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = animatoreService.authenticate(username, password);
        if (authenticated) {
            return new ResponseEntity<>("Login effettuato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenziali non valide", HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/salva-animatore")
    public ResponseEntity<String> salvaAnimatore() {
        animatoreService.salvaAnimatoreIniziale();
        return ResponseEntity.ok("animatore salvato con successo!");
    }
    @PostMapping("/creaAnimatore")
    public ResponseEntity<Object> addAnimatore(@RequestBody Animatore animatore) {
        try {
            // Aggiungi l'animatore nel database
            Animatore newAnimatore = animatoreService.addNewAnimatore(animatore);


            return new ResponseEntity<>(newAnimatore, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
*/