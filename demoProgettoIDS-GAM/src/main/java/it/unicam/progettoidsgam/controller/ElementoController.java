package it.unicam.progettoidsgam.controller;

//import it.unicam.progettoidsgam.Commento;
import it.unicam.progettoidsgam.modelli.Esperienza;
//import it.unicam.progettoidsgam.service.CommentoService;
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
    //private CommentoService commentoService;

    @Autowired
    public ElementoController(EsperienzaService esperienzaService,ContenutoService contenutoService) {
        this.contenutoService = contenutoService;
        this.esperienzaService=esperienzaService;

    }

   /* @PostMapping("/pubblicaContenuto")
    public ResponseEntity<Object> addContenuto(@RequestBody Contenuto e) {
        try{
            Contenuto newContenuto=contenutoService.addNewContenuto( e);
            return new ResponseEntity<>(newContenuto, HttpStatus.CREATED);
        }
        catch(ResourceAlreadyExistsException | IOException ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }*/
    @PostMapping(value="/pubblicaContenutoMultimediale", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> addContenutoMultimediale(@RequestParam("titolo") String titolo,@RequestParam("descrizione") String descrizione, @RequestParam("piRiferimento") String piRiferimento,@RequestParam("file") MultipartFile file) throws IOException {
        Contenuto contenuto = contenutoService.addContenutoMultimediale(titolo,descrizione,piRiferimento,file);
        return new ResponseEntity<>(contenuto.getImmagine(), HttpStatus.OK);
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

    @PostMapping(value="/creaContenutoMultimediale", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> creaContenutoMultimediale(@RequestParam("titolo") String titolo,@RequestParam("descrizione") String descrizione, @RequestParam("piRiferimento") String piRiferimento,@RequestParam("file") MultipartFile file) throws IOException {
        Contenuto contenuto = contenutoService.creaContenutoMultimediale(titolo,descrizione,piRiferimento,file);
        return new ResponseEntity<>(contenuto.getImmagine(), HttpStatus.OK);
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

   /* @PostMapping("/creaCommento")
    public ResponseEntity<Object> creaCommento(@RequestBody Commento commento) {
        try {
            // Aggiungi il commento nel database
            Commento newCommento = commentoService.creaNewCommento(commento);
            return new ResponseEntity<>(newCommento, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/commento/{titolo}")
    public ResponseEntity<Object> getCommento(@PathParam("titolo") String titolo) {
        return commentoService.getCommentoByTitolo(titolo);
    }
*/



}