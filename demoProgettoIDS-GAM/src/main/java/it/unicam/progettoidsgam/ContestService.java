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
    private ElementiCuratoreRepository<Contest> elementiCuratoreRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository, PIRepository piRepository,ElementiCuratoreRepository<Contest> elementiCuratoreRepository) throws IOException {
        this.contestRepository =contestRepository;
        this.piRepository=piRepository;
        this.elementiCuratoreRepository = elementiCuratoreRepository;
    }
    public ResponseEntity<Object> getContest(){
        return new ResponseEntity<>(contestRepository.findAll(), HttpStatus.OK);
    }
    public Contest addNewContest(Contest co) throws IOException {
        Optional<Contest> coOp= contestRepository.findByTitolo(co.getTitolo());
        Optional<PI> piOptional = piRepository.findByTitolo(co.getPiRiferimento());
        if (piOptional.isEmpty()) {
            throw new ResourceAlreadyExistsException("PI con ID " + co.getPiRiferimento() + " non trovato.");
        }
        if(coOp.isPresent()){
            throw new ResourceAlreadyExistsException("CON: " +co.getTitolo()+co.getDescrizione()+co.getPiRiferimento()+" esiste già");
        }
        if (co.getDataInizio().after(co.getDataFine()) || co.getDataInizio().equals(co.getDataFine())){
            throw new IllegalArgumentException("La data di inizio deve essere precedente alla data di fine.");
        }
        co.setIdContest();
        return elementiCuratoreRepository.save(co);
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
