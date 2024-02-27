package it.unicam.progettoidsgam.controller;


import it.unicam.progettoidsgam.service.EsperienzaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:63342")
@RestController
public class EsperienzaController {

    private final EsperienzaService esperienzaService;

    @Autowired
    public EsperienzaController(EsperienzaService esperienzaService){
        this.esperienzaService=esperienzaService;
    }

    @GetMapping("/esperienza/{titolo}")
    public ResponseEntity<Object> getEsperienza(@PathParam("titolo") String titolo){
        return esperienzaService.getEsperienza(titolo);
    }

    @GetMapping("/esperienze")
    public ResponseEntity<Object> getEsperienze(){
        return esperienzaService.getEsperienze();
    }
}
