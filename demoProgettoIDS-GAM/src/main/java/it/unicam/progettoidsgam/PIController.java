package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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


    @PostMapping("/pubblica")
    public ResponseEntity<Object> addPI(@RequestBody PI pi) {
        try {
            // Aggiungi il PI nel database
            PI newPI = piService.addNewPI(pi);
            return new ResponseEntity<>(newPI, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
  /*  @PostMapping("/crea")
    public ResponseEntity<Object> creaPI(@RequestBody PI pi,@RequestBody Contributore contributore) {
        try {
            // Aggiungi il PI nel database
            PI newPI = piService.creaNewPI(pi,contributore);
            return new ResponseEntity<>(newPI, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }*/
   @GetMapping("/PI/{titolo}")
    public ResponseEntity<Object> getPISingolo(@PathParam("titolo") String titolo) {
        return piService.getPIByTitolo(titolo);
    }

    @GetMapping("/{titolo}")
    public float getPILat(@PathParam("titolo") String titolo) {
        return piService.getPI(titolo);
    }
    @GetMapping("/Esperienza/{titolo}")
    public float getPILong(@PathParam("titolo") String titolo) {
        return piService.getPILong(titolo);
    }
}
