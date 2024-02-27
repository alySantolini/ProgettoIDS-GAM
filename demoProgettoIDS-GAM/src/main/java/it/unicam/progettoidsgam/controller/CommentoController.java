package it.unicam.progettoidsgam.controller;

import it.unicam.progettoidsgam.modelli.Commento;
import it.unicam.progettoidsgam.service.CommentoService;
import it.unicam.progettoidsgam.service.ContestService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:63342")
@RestController
public class CommentoController {

    private CommentoService commentoService;

    @Autowired
    public CommentoController(CommentoService commentoService) {
        this.commentoService = commentoService;

    }

    @GetMapping("/commento/{titolo}")
    public ResponseEntity<Object> getCommento(@PathParam("titolo") String titolo) {
        return commentoService.getCommentoByTitolo(titolo);
    }

    @GetMapping("/commenti")
    public ResponseEntity<Object> getCommenti(){
        return commentoService.getCommenti();
    }



}
