package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ContestService {

    private final ContestRepository contestRepository;
    private final PIRepository piRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository, PIRepository piRepository) throws IOException {
        this.contestRepository =contestRepository;
        this.piRepository=piRepository;
    }
    public ResponseEntity<Object> getContest(){
        return new ResponseEntity<>(contestRepository.findAll(), HttpStatus.OK);
    }
    public Contest addNewContest(Contest co) throws IOException {
        Optional<Contest> coOp= contestRepository.findById(co.getIdContest());
        Optional<PI> piOptional = piRepository.findByTitolo(co.getPiRiferimento());
        if (piOptional.isEmpty()) {
            throw new ResourceAlreadyExistsException("PI con ID " + co.getPiRiferimento() + " non trovato.");
        }
        if(coOp.isPresent()){
            throw new ResourceAlreadyExistsException("CON: " +co.getTitolo()+co.getDescrizione()+co.getPiRiferimento()+" esiste già");
        }
        co.setIdContest();
        return contestRepository.save(co);
    }

    public ContestRepository getRepository() {
        return contestRepository;}

    public ResponseEntity<Object> getContestByTitolo(String titolo) {
        // Implementa la logica per recuperare un punto di interesse dal repository in base al titolo
        // Esempio:
        Optional<Contest> contest = contestRepository.findByTitolo(titolo);
        if (contest != null) {
            return new ResponseEntity<>(contest, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
