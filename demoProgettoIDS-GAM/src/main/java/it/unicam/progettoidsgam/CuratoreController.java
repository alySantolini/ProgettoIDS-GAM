package it.unicam.progettoidsgam;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static it.unicam.progettoidsgam.Curatore.elementiCuratore;
import static it.unicam.progettoidsgam.Curatore.piCuratore;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class CuratoreController {

    @Autowired
    private CuratoreService curatoreService;

    public CuratoreController(CuratoreService curatoreService) {
        this.curatoreService = curatoreService;
        salvaCuratore();
    }
/*
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = contributoreService.authenticate(username, password);
        if (authenticated) {
            return new ResponseEntity<>("Login effettuato con successo", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Credenziali non valide", HttpStatus.UNAUTHORIZED);
        }
    }
    */

    @PostMapping("/salva-curatore")
    public ResponseEntity<String> salvaCuratore() {
        curatoreService.salva();
        return ResponseEntity.ok("Contributore salvato con successo!");
    }
    @GetMapping("/segnalazione/{idSegnalazione}")
    public ResponseEntity<Object> getSegnalazioneSingola(@PathParam ("idSegnalazione") String idSegnalazione){
        return curatoreService.getSegnalazione(idSegnalazione);
    }

    @PutMapping("/gestisci/{idSegnalazione}")
    public ResponseEntity<Object> gestisciSegnalazione(@PathParam("idSegnalazione")String idSegnalazione){
        return curatoreService.gestisciSegnalazione(idSegnalazione);
    }
    @PostMapping("/autorizza/PI")
    public ResponseEntity<Object> autorizzaPI(){
            for (PI pi: piCuratore) {
                piCuratore.remove(pi);
              return curatoreService.autorizzaPI(pi);
            }
        return null;
    }
    @PostMapping("/autorizzazione/Elemento")
    public ResponseEntity<Object> autorizzaElemento(){
        for (Elemento e: elementiCuratore) {
            elementiCuratore.remove(e);
            return curatoreService.autorizzaElemento(e);
        }
        return null;
    }
}

