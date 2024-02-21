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
public class ContestController {
    private ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;

    }
    @GetMapping("/AllContest")
    public ResponseEntity<Object> getElementi(){
        return contestService.getContest();
    }

    @PostMapping("/creaContest")
    public ResponseEntity<Object> addContest(@RequestBody Contest contest) {
        try {
            Contest newContest = contestService.addNewContest(contest);
            return new ResponseEntity<>(newContest, HttpStatus.CREATED);
        } catch (ResourceAlreadyExistsException | IOException e) {
            String errorMessage = "Errore durante l'aggiunta del contest: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/contest/{titolo}")
    public ResponseEntity<Object> getContest(@PathParam("titolo") String titolo) {
        return contestService.getContestByTitolo(titolo);
    }

    @GetMapping("/elementi/{titolo}")
    public ResponseEntity<Object> getContenutiContest(@PathParam("titolo") String titolo) {
        return contestService.getContenutiContest(titolo);
    }
    @DeleteMapping("/cancellaContest")
    public ResponseEntity<Object> cancellaContest() {
        return contestService.cancellaContest();
    }
}