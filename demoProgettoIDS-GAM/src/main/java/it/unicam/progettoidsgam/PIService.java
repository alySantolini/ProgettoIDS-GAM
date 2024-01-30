package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class PIService {

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
        if(pi1.isPresent()){
            throw new ResourceAlreadyExistsException("PI: " +pi.getTitolo()+pi.getDescrizione()+pi.getLongitudine()+pi.getLatitudine()+" esiste già");
        }
        pi.setIdPI();
        return piRepository.save(pi);
    }
   /* public ResponseEntity<Object> getPIByTitle(String titolo) {
        // Implementa la logica per recuperare un punto di interesse dal repository in base al titolo
        // Esempio:
        Optional<PI> pi = piRepository.findByTitle(titolo);
        if (pi != null) {
            return new ResponseEntity<>(pi, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    public PIRepository getRepository() {
        return piRepository;}
}