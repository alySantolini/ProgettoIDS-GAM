package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.repository.UtentiRepository;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.repository.AnimatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import it.unicam.progettoidsgam.modelli.Animatore;


import java.io.IOException;
import java.util.Optional;

@Service
public class AnimatoreService {

    private final AnimatoreRepository animatoreRepository;
    private final UtentiRepository<Animatore> utentiRepository;
    @Autowired
    public AnimatoreService(AnimatoreRepository animatoreRepository,UtentiRepository<Animatore> utentiRepository) {
        this.animatoreRepository=animatoreRepository;
        this.utentiRepository= utentiRepository;
    }
   public void salvaAnimatoreIniziale() {
        Animatore animatore = new Animatore("Nome","Cognome","animatore");
        utentiRepository.save(animatore);
    }

    public boolean authenticate(String nickname, String id) {
        Optional<Animatore> animatoreOptional = animatoreRepository.findById(id);
        if (animatoreOptional.isPresent()) {
            Animatore animatore = animatoreOptional.get();
            if (nickname.equals(animatore.getNickname()) && id.equals(animatore.getIdAnimatore())) {
                return true;
            }
        }
        return false;
    }
    public Animatore addNewAnimatore(Animatore animatore) throws IOException {
        Optional<Animatore> animatore1=animatoreRepository.findById(animatore.getIdAnimatore());
        Optional<Animatore> animatore2=animatoreRepository.findByNickname(animatore.getNickname());
        if(animatore1.isPresent() || animatore2.isPresent()){
            throw new ResourceAlreadyExistsException("animatore: " +animatore.getNickname()+" esiste già");
        }
        animatore.setIdAnimatore();
        return utentiRepository.save(animatore);
    }
    public ResponseEntity<Object> getAnimatori(){
        return new ResponseEntity<>(animatoreRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Object> getAnimatore(String idUtente) {
        Optional<Animatore> animatore = animatoreRepository.findById(idUtente);
        if (animatore != null) {
            return new ResponseEntity<>(animatore, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> getAnimatoreByNickname(String nickname) {
        Optional<Animatore> animatore = animatoreRepository.findByNickname(nickname);
        if (animatore != null) {
            return new ResponseEntity<>(animatore, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> cancellaAnimatore(String idUtente) {
        Optional<Animatore> animatore = animatoreRepository.findById(idUtente);
        if (animatore != null) {
            animatoreRepository.delete(animatore.get());
            return new ResponseEntity<>(animatore, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
