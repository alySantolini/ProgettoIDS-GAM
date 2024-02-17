package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

import static it.unicam.progettoidsgam.Curatore.piCuratore;

@Service
public class PIService {

    private static final double MIN_LATITUDINE = 43.8266;
    private static final double MAX_LATITUDINE = 43.8687;
    private static final double MIN_LONGITUDINE = 13.0148;
    private static final double MAX_LONGITUDINE = 13.0767;
    private final PIRepository piRepository;
    @Autowired
    public PIService(PIRepository piRepository){
        this.piRepository=piRepository;
    }

    public ResponseEntity<Object> getPI(){
        return new ResponseEntity<>(piRepository.findAll(), HttpStatus.OK);
    }

   public PI addNewPI(PI pi) throws IOException {
        Optional<PI> pi1=piRepository.findById(pi.getIdPI());
        Optional<PI> pi2= piRepository.findByTitolo(pi.getTitolo());
        if(pi1.isPresent() || pi2.isPresent()){
            throw new ResourceAlreadyExistsException("PI: " +pi.getTitolo()+pi.getDescrizione()+pi.getLongitudine()+pi.getLatitudine()+" esiste già");
        }
       if(controlloCordinate(pi.getLatitudine(),pi.getLongitudine())) {
           pi.setIdPI();
           return piRepository.save(pi);
       }else{
       throw new IllegalArgumentException("le cordinate sono errate");}
   }

    public PI creaNewPI(PI pi) throws IOException {
        for(PI piNA: piCuratore){
        if(piNA.getIdPI().equals(pi.getIdPI()) || piNA.getTitolo().equals(pi.getTitolo()) ){
            throw new ResourceAlreadyExistsException("PI: " +pi.getTitolo()+pi.getDescrizione()+pi.getLongitudine()+pi.getLatitudine()+" esiste già");
        }
    }
        if(controlloCordinate(pi.getLatitudine(),pi.getLongitudine())){
        pi.setIdPI();
        piCuratore.add(pi);
        return pi;}

        throw new IllegalArgumentException("le cordinate sono errate");
    }

    public ResponseEntity<Object> getPIByTitolo(String titolo) {
        Optional<PI> pi = piRepository.findByTitolo(titolo);
        if (pi != null) {
            return new ResponseEntity<>(pi, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static boolean controlloCordinate(double latitudine, double longitudine) {
        return latitudine >= MIN_LATITUDINE && latitudine <= MAX_LATITUDINE &&
                longitudine >= MIN_LONGITUDINE && longitudine <= MAX_LONGITUDINE;
    }

    /*
        public float getPI(String titolo) {
            // Implementa la logica per recuperare un punto di interesse dal repository in base al titolo
            // Esempio:
            Optional<PI> pi = piRepository.findByTitolo(titolo);
            if (pi != null) {
                return  pi.get().getLatitudine();
            } else {
             return 0;
            }
        }
        /*
        public float getPILong(String titolo) {
            // Implementa la logica per recuperare un punto di interesse dal repository in base al titolo
            // Esempio:
            Optional<PI> pi = piRepository.findByTitolo(titolo);
            if (pi != null) {
                return  pi.get().getLongitudine();
            } else {
                return 0;
            }
        }
    */
    public PIRepository getRepository() {
        return piRepository;}
}