package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ContestService {

    private final ContestRepository contestRepository;
    private final PIRepository piRepository;
    private ElementiRepository<Contest> elementiRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository, PIRepository piRepository, ElementiRepository<Contest> elementiRepository) throws IOException {
        this.contestRepository =contestRepository;
        this.piRepository=piRepository;
        this.elementiRepository = elementiRepository;
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
        return elementiRepository.save(co);
    }

    public ContestRepository getRepository() {
        return contestRepository;}

    public ResponseEntity<Object> getContestByTitolo(String titolo) {
        Optional<Contest> contest = contestRepository.findByTitolo(titolo);
        if (contest != null) {
            return new ResponseEntity<>(contest, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   /* public ResponseEntity<Object> partecipa(String idContest){
        Optional<Contest> contest = contestRepository.findById(idContest);
        String pi=contest.get().getPiRiferimento();

    }*/
}
