package it.unicam.progettoidsgam.controller;

import it.unicam.progettoidsgam.service.AnimatoreService;
import it.unicam.progettoidsgam.modelli.Animatore;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import jakarta.websocket.server.PathParam;
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

  /*  @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = animatoreService.authenticate(username, password);
        if (authenticated) {
            return new ResponseEntity<>("Login effettuato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenziali non valide", HttpStatus.UNAUTHORIZED);
        }
    }*/

    @GetMapping("/allAnimatore")
    public ResponseEntity<Object> getAnimatori() {
        return animatoreService.getAnimatori();
    }
     @PostMapping("/salva-animatore")
    public ResponseEntity<String> salvaAnimatore() {
        animatoreService.salvaAnimatoreIniziale();
        return ResponseEntity.ok("animatore salvato con successo!");
    }
    @PostMapping("/creaAnimatore")
    public ResponseEntity<Object> addAnimatore(@RequestBody Animatore animatore) {
        try {
            Animatore newAnimatore = animatoreService.addNewAnimatore(animatore);
            return new ResponseEntity<>(newAnimatore, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/animatore/{idUtente}")
    public ResponseEntity<Object> getAnimatore(@PathParam("idUtente") String idUtente) {
        return animatoreService.getAnimatore(idUtente);
    }
    @GetMapping("/animatore/{nickname}")
    public ResponseEntity<Object> getAnimatoreByNickname(@PathParam("nickname") String nickname) {
        return animatoreService.getAnimatoreByNickname(nickname);
    }

    @DeleteMapping("/cancellaAnimatore/{idUtente}")
    public ResponseEntity<Object> cancellaAnimatore(@PathParam("idUtente") String idUtente) {
        return animatoreService.cancellaAnimatore(idUtente);
    }
}
