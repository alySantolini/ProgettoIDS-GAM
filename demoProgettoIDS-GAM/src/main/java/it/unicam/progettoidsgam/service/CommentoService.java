package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.modelli.Commento;
import it.unicam.progettoidsgam.modelli.PI;
import it.unicam.progettoidsgam.repository.PIRepository;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.modelli.Elemento;
import it.unicam.progettoidsgam.repository.CommentoRepository;
import it.unicam.progettoidsgam.repository.ElementiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

import static it.unicam.progettoidsgam.modelli.Curatore.elementiCuratore;

@Service
public class CommentoService {

    private final CommentoRepository commentoRepository;
    private final PIRepository piRepository;
    private final ElementiRepository<Elemento> elementiRepository;

    @Autowired
    public CommentoService(CommentoRepository commentoRepository, PIRepository piRepository, ElementiRepository<Elemento> elementiRepository) throws IOException {
        this.commentoRepository =commentoRepository;
        this.piRepository=piRepository;
        this.elementiRepository = elementiRepository;
    }


    public ResponseEntity<Object> getCommenti(){
        return new ResponseEntity<>(commentoRepository.findAll(), HttpStatus.OK);
    }

    public Commento addNewCommento(Commento co) throws IOException {
        Optional<Commento> co1= commentoRepository.findByTitolo(co.getTitolo());
        Optional<PI> piOptional = piRepository.findByTitolo(co.getPiRiferimento());
        if (piOptional.isEmpty()) {
            throw new ResourceAlreadyExistsException("PI con ID " + co.getPiRiferimento() + " non trovato.");
        }
        if(co1.isPresent()){
            throw new ResourceAlreadyExistsException("CO: " +co.getTitolo()+co.getDescrizione()+co.getPiRiferimento()+" esiste già");
        }
        co.setIdCommento();
        return commentoRepository.save(co);
    }
   public Commento creaNewCommento(Commento co) throws IOException {
        Optional<Commento> co1= commentoRepository.findById(co.getTitolo());
        Optional<PI> piOptional = piRepository.findByTitolo(co.getPiRiferimento());
        if (piOptional.isEmpty()) {
            throw new ResourceAlreadyExistsException("PI con ID " + co.getPiRiferimento() + " non trovato.");
        }
        if(co1.isPresent()){
            throw new ResourceAlreadyExistsException("CO: " +co.getTitolo()+co.getDescrizione()+co.getPiRiferimento()+" esiste già");
        }
        co.setIdCommento();
        elementiCuratore.add(co);
        return co;
    }
    public ResponseEntity<Object> getCommentoByTitolo(String titolo) {
        Optional<Commento> commento = commentoRepository.findByTitolo(titolo);
        if (commento != null) {
            return new ResponseEntity<>(commento, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public CommentoRepository getRepository() {
        return commentoRepository;
    }

}