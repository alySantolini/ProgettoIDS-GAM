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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins="http://localhost:63342")
@RestController
public class ElementoController {
    private ContenutoService contenutoService;
    private EsperienzaService esperienzaService;

    private CommentoService commentoService;

    @Autowired
    public ElementoController(ContenutoService contenutoService,EsperienzaService esperienzaService, CommentoService commentoService) {
        this.contenutoService = contenutoService;
        this.esperienzaService=esperienzaService;
        this.commentoService=commentoService;

    }

    @PostMapping(value="/pubblicaContenutoMultimediale", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> addContenutoMultimediale(@RequestParam("titolo") String titolo,@RequestParam("descrizione") String descrizione, @RequestParam("piRiferimento") String piRiferimento,@RequestParam("file") MultipartFile file) throws IOException {
        Contenuto contenuto = contenutoService.addContenutoMultimediale(titolo,descrizione,piRiferimento,file);
        contenuto.creazione();
        return new ResponseEntity<>(contenuto.getImmagine(), HttpStatus.OK);
    }


    @PostMapping(value="/creaContenutoMultimediale", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> creaContenutoMultimediale(@RequestParam("titolo") String titolo,@RequestParam("descrizione") String descrizione, @RequestParam("piRiferimento") String piRiferimento,@RequestParam("file") MultipartFile file) throws IOException {
        Contenuto contenuto = contenutoService.creaContenutoMultimediale(titolo,descrizione,piRiferimento,file);
        contenuto.creazione();
        return new ResponseEntity<>(contenuto.getImmagine(), HttpStatus.OK);
    }


    @PostMapping("/pubblicaEsperienza")
    public ResponseEntity<Object> addEsperienza(@RequestBody Esperienza esperienza) {
        try {
            Esperienza newEsperienza = esperienzaService.addNewEsperienza(esperienza);
            esperienza.creazione();
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
            esperienza.creazione();
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
            commento.creazione();
            return new ResponseEntity<>(newCommento, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}