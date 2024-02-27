package it.unicam.progettoidsgam.controller;

import it.unicam.progettoidsgam.service.ContenutoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:63342")
@RestController
public class ContenutoController {


    private final ContenutoService contenutoService;
    @Autowired
    public ContenutoController(ContenutoService contenutoService){
        this.contenutoService=contenutoService;
    }

    @GetMapping("/contenuti")
    public ResponseEntity<Object> getElementi(){
        return contenutoService.getContenuti();
    }

    @GetMapping("/contenuto/{titolo}")
    public ResponseEntity<Object> getContenuto(@PathParam("titolo") String titolo) {
        return contenutoService.getContenutoByTitolo(titolo);
    }

    @PostMapping("/partecipa/{contest}")
    public ResponseEntity<Object> partecipaContest(@PathParam("contest") String contest) {
        return contenutoService.partecipa(contest);
    }
}
