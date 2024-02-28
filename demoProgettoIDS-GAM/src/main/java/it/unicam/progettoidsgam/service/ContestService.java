package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.modelli.Elemento;
import it.unicam.progettoidsgam.modelli.PI;
import it.unicam.progettoidsgam.repository.PIRepository;
import it.unicam.progettoidsgam.modelli.Contest;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static it.unicam.progettoidsgam.modelli.Contest.elementiContest;

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
        return contestRepository.save(co);
    }

    public ContestRepository getRepository() {
        return contestRepository;
    }

    public ResponseEntity<Object> getContestByTitolo(String titolo) {
        Optional<Contest> contest = contestRepository.findByTitolo(titolo);
        if (contest != null) {
            return new ResponseEntity<>(contest, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Object> getContenutiContest(String titolo) {
        Optional<Contest> contest = contestRepository.findByTitolo(titolo);
        if (contest != null) {
            for (Elemento e:elementiContest) {
                System.out.println(e);
            }
            return new ResponseEntity<>(elementiContest, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Object> cancellaContest() {
         Date dataCorrente = new Date();
        List<Contest> contest = contestRepository.findAll();
        for (Contest c: contest) {
            if(c.getDataFine().getTime()==dataCorrente.getTime()){
                contestRepository.delete(c);
            }
            return new  ResponseEntity<>(contestRepository, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
