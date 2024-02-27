package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.repository.UtentiRepository;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.modelli.Contributore;
import it.unicam.progettoidsgam.repository.ContributoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ContributoreService {

    private final ContributoreRepository contributoreRepository;
    private final UtentiRepository<Contributore> utentiRepository;

    @Autowired
    public ContributoreService(UtentiRepository<Contributore> utentiRepository,ContributoreRepository contributoreRepository) {
        this.contributoreRepository=contributoreRepository;
        this.utentiRepository=utentiRepository;
    }

    public void salvaContributoreIniziale() {
        Contributore contributore = new Contributore("Nome", "Cognome", "contributoreA", true);
        Contributore contributore1=new Contributore("ali","santolini","contributore",false);
        // Imposta altri attributi se necessario
        utentiRepository.save(contributore);
        utentiRepository.save(contributore1);
    }
    public boolean authenticate(String nickname, String id) {
        Optional<Contributore> contributoreOptional = contributoreRepository.findById(id);
        if (contributoreOptional.isPresent()) {
            Contributore contributore = contributoreOptional.get();
            if (nickname.equals(contributore.getNickname()) && id.equals(contributore.getIdContributore())) {
                return true;
            }
        }
        return false;
    }
    public Contributore addNewContributore(Contributore contributore) throws IOException {
        Optional<Contributore> contributore1=contributoreRepository.findById(contributore.getIdContributore());
        Optional<Contributore> contributore2=contributoreRepository.findByNickname(contributore.getNickname());
        if(contributore1.isPresent() || contributore2.isPresent()){
            throw new ResourceAlreadyExistsException("Contributore: " +contributore.getNickname()+" esiste già");
        }
        contributore.setIdContributore();
        return utentiRepository.save(contributore);
    }

    public ResponseEntity<Object> getContributore(String idUtente) {
        Optional<Contributore> contributore = contributoreRepository.findById(idUtente);
        if (contributore != null) {
            return new ResponseEntity<>(contributore, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> getContributoreByNickname(String nickname) {
        Optional<Contributore> contributore = contributoreRepository.findByNickname(nickname);
        if (contributore != null) {
            return new ResponseEntity<>(contributore, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> cancellaContributore(String idUtente) {
        Optional<Contributore> contributore = contributoreRepository.findById(idUtente);
        if (contributore != null) {
            contributoreRepository.delete(contributore.get());
            return new ResponseEntity<>(contributore, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
