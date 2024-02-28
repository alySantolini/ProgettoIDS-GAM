package it.unicam.progettoidsgam.controller;

import it.unicam.progettoidsgam.service.CuratoreService;
import it.unicam.progettoidsgam.modelli.Elemento;
import it.unicam.progettoidsgam.modelli.PI;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static it.unicam.progettoidsgam.modelli.Curatore.elementiCuratore;
import static it.unicam.progettoidsgam.modelli.Curatore.piCuratore;


@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class CuratoreController {

    @Autowired
    private CuratoreService curatoreService;


    public CuratoreController(CuratoreService curatoreService) {
        this.curatoreService = curatoreService;
        salvaCuratore();
    }

    @PostMapping("/salva-curatore")
    public ResponseEntity<String> salvaCuratore() {
        curatoreService.salva();
        return ResponseEntity.ok("Contributore salvato con successo!");
    }

    @PutMapping("/gestisci/{idSegnalazione}")
    public ResponseEntity<Object> gestisciSegnalazione(@PathParam("idSegnalazione")String idSegnalazione){
        return curatoreService.gestisciSegnalazione(idSegnalazione);
    }
    @PostMapping("/autorizza/{idPI}")
    public ResponseEntity<Object> autorizzaPI(@PathParam("idPI") String idPI){
            for (PI pi: piCuratore) {
                if(pi.getIdPI().equals(idPI)){
                piCuratore.remove(pi);
              return curatoreService.autorizzaPI(pi);}
            }
        return new ResponseEntity<>("Errore durante l'autorizzazione " , HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/autorizzazione/{idElemento}")
    public ResponseEntity<Object> autorizzaElemento(@PathParam("idElemento") String idElemento){
        for (Elemento e: elementiCuratore) {
            if(e.getIdElemento().equals(idElemento)){
                elementiCuratore.remove(e);
                return curatoreService.autorizzaElemento(e);}
        }
        return new ResponseEntity<>("Errore durante l'autorizzazione " , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getPIDaAutorizzare")
    public ResponseEntity<Object> getPI(){
        return curatoreService.getPI();
    }
    @GetMapping("/getListaDaAutorizzare")
    public ResponseEntity<Object> getLista(){
        return curatoreService.getLista();
    }
}

