package it.unicam.progettoidsgam.controller;

import it.unicam.progettoidsgam.service.TuristaService;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.modelli.Turista;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class TuristaController {
    private TuristaService turistaService;

    @Autowired
    public TuristaController(TuristaService turistaService) {
        this.turistaService = turistaService;
        salvaTurista();
    }

    @PostMapping("/salvaTurista")
    public ResponseEntity<String> salvaTurista(){
        turistaService.salvaTuristaIniziale();
        return ResponseEntity.ok("Turista salvato con successo!");
    }



    @PostMapping("/creaTurista")
    public ResponseEntity<Object> addTurista(@RequestBody Turista turista) {
        try {
            Turista newTurista = turistaService.addNewTurista(turista);
            return new ResponseEntity<>(newTurista, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/turista/{idUtente}")
    public ResponseEntity<Object> getContributore(@PathParam("idUtente") String idUtente) {
        return turistaService.getTurista(idUtente);
    }
    @GetMapping("/turista/{nickname}")
    public ResponseEntity<Object> getContributoreByNickname(@PathParam("nickname") String nickname) {
        return turistaService.getTuristaByNickname(nickname);
    }
    @DeleteMapping("/cancellaTurista/{idUtente}")
    public ResponseEntity<Object> cancellaAnimatore(@PathParam("idUtente") String idUtente) {
        return turistaService.cancellaTurista(idUtente);
    }
}
