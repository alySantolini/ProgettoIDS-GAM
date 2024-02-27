package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.modelli.Elemento;
import it.unicam.progettoidsgam.modelli.Segnalazione;
import it.unicam.progettoidsgam.repository.ElementiRepository;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.repository.SegnalazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SegnalazioneService {
    private SegnalazioneRepository segnalazioneRepository;

    private ElementiRepository<Elemento> elementiRepository;


    @Autowired
    public SegnalazioneService(SegnalazioneRepository segnalazioneRepository, ElementiRepository<Elemento> elementiRepository) throws IOException {
        this.segnalazioneRepository = segnalazioneRepository;
        this.elementiRepository=elementiRepository;
    }

    public Segnalazione addNewSegnalazione(Segnalazione segnalazione) throws IOException {
        Optional<Segnalazione> so1 = segnalazioneRepository.findById(segnalazione.getIdSegnalazione());
        if (so1.isPresent()) {
            throw new ResourceAlreadyExistsException("S: " + segnalazione.getIdSegnalazione() + " esiste già");
        }
        segnalazione.setIdSegnalazione();
        return segnalazioneRepository.save(segnalazione);
    }

    public SegnalazioneRepository getRepository() {
        return segnalazioneRepository;
    }

    public ResponseEntity<Object> getSegnalazioni() {
        return new ResponseEntity<>(segnalazioneRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getSegnalazione(String idSegnalazione) {
        Optional<Segnalazione> segnalazione = segnalazioneRepository.findById(idSegnalazione);
        if (segnalazione != null) {
            return new ResponseEntity<>(segnalazione, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Elemento> getElementiSegnalazione(String idSegnalazione) {
        Optional<Segnalazione> segnalazione = segnalazioneRepository.findById(idSegnalazione);
        List<Elemento> listaElementi=new ArrayList<>();
        if (segnalazione != null) {
            for (Elemento e : elementiRepository.findAll()) {
                if(e.getIdElemento().equals(segnalazione.get().getIdElemento())){
                    listaElementi.add(e);
                }
            }
            return listaElementi;
        } else {
            return null;
        }
    }

}