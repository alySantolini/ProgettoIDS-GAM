package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PIService {

    private final PIRepository piRepository;
private final ElementiCuratoreRepository elementiCuratoreRepository;
    @Autowired
    public PIService(PIRepository piRepository,ElementiCuratoreRepository elementiCuratoreRepository){
        this.piRepository=piRepository;
        this.elementiCuratoreRepository=elementiCuratoreRepository;
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
       /* if(!contributore.getAutorizzato()) {
            elementiCuratoreRepository.save(pi);
        }*/
        return piRepository.save(pi);
    }
    /*public PI creaNewPI(PI pi,Contributore contributore) throws IOException {
        Optional<PI> pi1=piRepository.findById(pi.getIdPI());
        if(pi1.isPresent()){
            throw new ResourceAlreadyExistsException("PI: " +pi.getTitolo()+pi.getDescrizione()+pi.getLongitudine()+pi.getLatitudine()+" esiste già");
        }
        pi.setIdPI();
       if(!contributore.getAutorizzato()) {
            elementiCuratoreRepository.save(pi);
        }
        return piRepository.save(pi);
    }*/

    public ResponseEntity<Object> getPIByTitolo(String titolo) {
        // Implementa la logica per recuperare un punto di interesse dal repository in base al titolo
        // Esempio:
        Optional<PI> pi = piRepository.findByTitolo(titolo);
        if (pi != null) {
            return new ResponseEntity<>(pi, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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

    public PIRepository getRepository() {
        return piRepository;}
}