package it.unicam.progettoidsgam.controller;


import it.unicam.progettoidsgam.modelli.PI;
import it.unicam.progettoidsgam.service.PIService;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins="http://localhost:63342")
@RestController
public class PIController {

    public final PIService piService;

    @Autowired
    public PIController(PIService piService) {
        this.piService = piService;
    }
    @GetMapping("/AllPI")
    public ResponseEntity<Object> getPI(){
        return piService.getPI();
    }
  @PostMapping("/pubblicaPI")
    public ResponseEntity<Object> addPI(@RequestBody PI pi) {
        try {
            PI newPI = piService.addNewPI(pi);
            return new ResponseEntity<>(newPI, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException  e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/creaPI")
    public ResponseEntity<Object> creaPI(@RequestBody PI pi) {
        try {
            PI newPI = piService.creaNewPI(pi);
            return new ResponseEntity<>(newPI, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/PI/{titolo}")
    public ResponseEntity<Object> getPISingolo(@PathParam("titolo") String titolo) {
        return piService.getPIByTitolo(titolo);

    }

    @GetMapping("/PI/elementi/{titolo}")
    public ResponseEntity<Object> getElemento(@PathParam("titolo") String titolo) {
        return piService.getElementi(titolo);
    }
}
