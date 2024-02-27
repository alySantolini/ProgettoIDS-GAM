package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.repository.ElementiRepository;
import it.unicam.progettoidsgam.modelli.Elemento;
import it.unicam.progettoidsgam.PI;
import it.unicam.progettoidsgam.PIRepository;
import it.unicam.progettoidsgam.modelli.Contenuto;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static it.unicam.progettoidsgam.modelli.Contest.elementiContest;
import static it.unicam.progettoidsgam.modelli.Curatore.elementiCuratore;

import java.io.IOException;
import java.util.Optional;

@Service
public class ContenutoService {


    private final ContenutoRepository contenutoRepository;
    private final PIRepository piRepository;
    private final ElementiRepository<Elemento> elementiRepository;

    @Autowired
    public ContenutoService(ContenutoRepository contenutoRepository, PIRepository piRepository, ElementiRepository<Elemento> elementiRepository) throws IOException {
        this.contenutoRepository =contenutoRepository;
        this.piRepository=piRepository;
        this.elementiRepository = elementiRepository;
    }


    public ResponseEntity<Object> getContenuti(){
        return new ResponseEntity<>(contenutoRepository.findAll(), HttpStatus.OK);
    }

    public Contenuto addNewContenuto(Contenuto co) throws IOException {
        Optional<Contenuto> co1= contenutoRepository.findById(co.getIdContenuto());
        Optional<PI> piOptional = piRepository.findByTitolo(co.getPiRiferimento());
        if (piOptional.isEmpty()) {
            throw new ResourceAlreadyExistsException("PI con ID " + co.getPiRiferimento() + " non trovato.");
        }
        if(co1.isPresent()){
            throw new ResourceAlreadyExistsException("CO: " +co.getTitolo()+co.getDescrizione()+co.getPiRiferimento()+" esiste già");
        }
            co.setIdContenuto();
        return  elementiRepository.save(co);
            // contenutoRepository.save(co);
    }
    public Contenuto creaNewContenuto(Contenuto co) throws IOException {
        Optional<Contenuto> co1= contenutoRepository.findById(co.getIdContenuto());
        Optional<PI> piOptional = piRepository.findByTitolo(co.getPiRiferimento());
        if (piOptional.isEmpty()) {
            throw new ResourceAlreadyExistsException("PI con ID " + co.getPiRiferimento() + " non trovato.");
        }
        if(co1.isPresent()){
            throw new ResourceAlreadyExistsException("CO: " +co.getTitolo()+co.getDescrizione()+co.getPiRiferimento()+" esiste già");
        }
        co.setIdContenuto();
        elementiCuratore.add(co);
        return co;
    }
    public ResponseEntity<Object> getContenutoByTitolo(String titolo) {
        Optional<Contenuto> contenuto = contenutoRepository.findByTitolo(titolo);
        if (contenuto != null) {
            return new ResponseEntity<>(contenuto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> partecipa(String titolo) {
        Optional<Elemento> contest = elementiRepository.findByTitolo(titolo);
        if(contest.isPresent()){
            Contenuto contenuto=getUltimoContenuto();
            elementiContest.add(contenuto);
            return new ResponseEntity<>(contenuto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   public Contenuto getUltimoContenuto() {
       Optional<Contenuto> ultimoContenuto = contenutoRepository.findFirstByOrderByIdElementoDesc();
       return ultimoContenuto.orElse(null);
   }
    public ContenutoRepository getRepository() {
        return contenutoRepository;}

}