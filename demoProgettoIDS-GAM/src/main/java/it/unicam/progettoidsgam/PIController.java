package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
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


    @PostMapping("/create")
    public ResponseEntity<Object> addPI(@RequestBody PI pi) {
        try {
            // Aggiungi il PI nel database
            PI newPI = piService.addNewPI(pi);


            return new ResponseEntity<>(newPI, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
  /*  @GetMapping("/PI/{titolo}")
    public ResponseEntity<Object> getPISingolo(@PathVariable("titolo") String titolo) {
        return piService.getPIByTitle(titolo);
    }*/
}
