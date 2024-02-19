package it.unicam.progettoidsgam;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;

@CrossOrigin(origins="http://localhost:63342")
@RestController
public class EsperienzaController {

    public final EsperienzaService esperienzaService;

    @Autowired
    public EsperienzaController(EsperienzaService esperienzaService) {
        this.esperienzaService = esperienzaService;
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


