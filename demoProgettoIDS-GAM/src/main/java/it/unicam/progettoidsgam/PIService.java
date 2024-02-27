package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.modelli.Elemento;
import it.unicam.progettoidsgam.repository.ElementiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static it.unicam.progettoidsgam.modelli.Curatore.piCuratore;

@Service
public class PIService {

    private static final double MIN_LATITUDINE = 43.8266;
    private static final double MAX_LATITUDINE = 43.8687;
    private static final double MIN_LONGITUDINE = 13.0148;
    private static final double MAX_LONGITUDINE = 13.0767;
    private final PIRepository piRepository;
    private final ElementiRepository elementiRepository;
    @Autowired
    public PIService(PIRepository piRepository,ElementiRepository elementiRepository){
        this.piRepository=piRepository;
        this.elementiRepository=elementiRepository;
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
       if(controlloCordinate(pi.getLatitudine(),pi.getLongitudine()) ) {
           pi.setIdPI();
           return piRepository.save(pi);
       }else{
       throw new IllegalArgumentException("le coordinate sono errate");}
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
        return pi;
        }
        throw new IllegalArgumentException("le cordinate sono errate");
    }

    public ResponseEntity<Object> getPIByTitolo(String titolo) {
        Optional<PI> pi = piRepository.findByTitolo(titolo);
        if (pi.isPresent()) {
            return ResponseEntity.ok(pi.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> getElementi(String titolo){
        Optional<PI> pi = piRepository.findByTitolo(titolo);
        if(pi.isPresent()){
           List<Elemento> lista= elementiRepository.findAll();
            List<Elemento> lista1=new ArrayList<>();
           for (Elemento e : lista){
               e.getPiRiferimento().equals(titolo);
               lista1.add(e);
            }
            return new ResponseEntity<>(lista1,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
    public static boolean controlloCordinate(double latitudine, double longitudine) {
        return latitudine >= MIN_LATITUDINE && latitudine <= MAX_LATITUDINE &&
                longitudine >= MIN_LONGITUDINE && longitudine <= MAX_LONGITUDINE;
    }
    public PIRepository getRepository() {
        return piRepository;}
}