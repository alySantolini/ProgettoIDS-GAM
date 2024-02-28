package it.unicam.progettoidsgam.controller;

import it.unicam.progettoidsgam.service.ContributoreService;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.modelli.Contributore;
import jakarta.websocket.server.PathParam;
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
    @PostMapping("/salva-contributore")
    public ResponseEntity<String> salvaContributore() {
        contributoreService.salvaContributoreIniziale();
        return ResponseEntity.ok("Contributore salvato con successo!");
    }
    @PostMapping("/creaContributore")
    public ResponseEntity<Object> addContributore(@RequestBody Contributore contributore) {
        try {
            Contributore newContributore = contributoreService.addNewContributore(contributore);
             return new ResponseEntity<>(newContributore, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/contributore/{idUtente}")
    public ResponseEntity<Object> getContributore(@PathParam("idUtente") String idUtente) {
        return contributoreService.getContributore(idUtente);
    }
    @GetMapping("/contributore/{nickname}")
    public ResponseEntity<Object> getContributoreByNickname(@PathParam("nickname") String nickname) {
        return contributoreService.getContributoreByNickname(nickname);
    }
    @DeleteMapping("/cancellaContributore/{idUtente}")
    public ResponseEntity<Object> cancellaAnimatore(@PathParam("idUtente") String idUtente) {
        return contributoreService.cancellaContributore(idUtente);
    }
}
