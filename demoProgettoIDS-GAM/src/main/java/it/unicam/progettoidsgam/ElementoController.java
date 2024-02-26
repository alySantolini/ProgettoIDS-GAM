package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
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
    @GetMapping("/contenuto/{titolo}")
    public ResponseEntity<Object> getContenuto(@PathParam("titolo") String titolo) {
        return contenutoService.getContenutoByTitolo(titolo);
    }

    @PostMapping("/partecipa/{contest}")
    public ResponseEntity<Object> partecipaContest(@PathParam("contest") String contest) {
        return contenutoService.partecipa(contest);
    }
    @GetMapping("/esperienza/{titolo}")
    public ResponseEntity<Object> getEsperienza(@PathParam("titolo") String titolo){
        return esperienzaService.getEsperienza(titolo);
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
}