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
public class SegnalazioneController {


    private SegnalazioneService segnalazioneService;
   // private final SegnalazioneRepository segnalazioneRepository;

    @Autowired
    public SegnalazioneController(SegnalazioneService segnalazioneService) {
        this.segnalazioneService = segnalazioneService;

    }
    @PostMapping("/pubblicaSegnalazione")
    public ResponseEntity<Object> addSegnalazione(@RequestBody Segnalazione segnalazione) {
        try {
            // Aggiungi il contenuto nel database
            Segnalazione newSegnalazione = segnalazioneService.addNewSegnalazione(segnalazione);
         return new ResponseEntity<>(newSegnalazione, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getSegnalazioni")
    public ResponseEntity<Object> getSegnalazioni(){
        return segnalazioneService.getSegnalazioni();
    }

    @GetMapping("/segnalazione/{idSegnalazione}")
    public ResponseEntity<Object> getSegnalazioneSingola(@PathParam("idSegnalazione") String idSegnalazione){
        return segnalazioneService.getSegnalazione(idSegnalazione);
    }

    /*@GetMapping("/elimina/{id}")
    public String eliminaSegnalazione(@PathVariable String id) {
        segnalazioneService.eliminaSegnalazione(id);
        return "redirect:/pagina-successo"; // Reindirizza a una pagina di successo o altrove
    }*/
}