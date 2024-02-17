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
public class ContenutoController {


    private ContenutoService contenutoService;

    @Autowired
    public ContenutoController(ContenutoService contenutoService) {
        this.contenutoService = contenutoService;

    }
    @GetMapping("/elementi")
    public ResponseEntity<Object> getElementi(){
        return contenutoService.getContenuti();
    }

    @PostMapping("/pubblicaContenuto")
    public ResponseEntity<Object> addContenuto(@RequestBody Contenuto contenuto) {
        try {
            // Aggiungi il contenuto nel database
            Contenuto newContenuto = contenutoService.addNewContenuto(contenuto);

            return new ResponseEntity<>(newContenuto, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
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
}