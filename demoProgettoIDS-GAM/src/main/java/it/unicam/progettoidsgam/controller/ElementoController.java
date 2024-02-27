package it.unicam.progettoidsgam.controller;

import it.unicam.progettoidsgam.modelli.Commento;
import it.unicam.progettoidsgam.modelli.Esperienza;
import it.unicam.progettoidsgam.service.CommentoService;
import it.unicam.progettoidsgam.service.EsperienzaService;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.modelli.Contenuto;
import it.unicam.progettoidsgam.modelli.Elemento;
import it.unicam.progettoidsgam.service.ContenutoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins="http://localhost:63342")
@RestController
public class ElementoController {
    private ContenutoService contenutoService;
    private EsperienzaService esperienzaService;

    private CommentoService commentoService;

    @Autowired
    public ElementoController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;

    }

    @PostMapping("/pubblicaContenuto")
    public ResponseEntity<Object> addElemento(@RequestBody Contenuto e) {
        try{
            Elemento newElemento=contenutoService.addNewContenuto( e);
            return new ResponseEntity<>(newElemento, HttpStatus.CREATED);
        }
        catch(ResourceAlreadyExistsException | IOException ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }



    @PostMapping("/creaContenuto")
    public ResponseEntity<Object> creaContenuto(@RequestBody Contenuto contenuto) {
        try {
            // Aggiungi il contenuto nel database
            Contenuto newContenuto = contenutoService.creaNewContenuto(contenuto);
            return new ResponseEntity<>(newContenuto, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/pubblicaEsperienza")
    public ResponseEntity<Object> addEsperienza(@RequestBody Esperienza esperienza) {
        try {
            Esperienza newEsperienza = esperienzaService.addNewEsperienza(esperienza);
            return new ResponseEntity<>(newEsperienza, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/creaEsperienza")
    public ResponseEntity<Object> creaEsperienza(@RequestBody Esperienza esperienza) {
        try {
            // Aggiungi il contenuto nel database
            Esperienza newEsperienza = esperienzaService.creaNewEsperienza(esperienza);
            return new ResponseEntity<>(newEsperienza, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/creaCommento")
    public ResponseEntity<Object> creaCommento(@RequestBody Commento commento) {
        try {
            // Aggiungi il commento nel database
            Commento newCommento = commentoService.creaNewCommento(commento);
            return new ResponseEntity<>(newCommento, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}