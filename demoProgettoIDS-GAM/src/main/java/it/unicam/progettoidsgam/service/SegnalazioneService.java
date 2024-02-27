package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.modelli.Segnalazione;
import it.unicam.progettoidsgam.repository.ElementiRepository;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.repository.SegnalazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class SegnalazioneService {
    private SegnalazioneRepository segnalazioneRepository;


    @Autowired
    public SegnalazioneService(SegnalazioneRepository segnalazioneRepository, ElementiRepository elementiRepository) throws IOException {
        this.segnalazioneRepository = segnalazioneRepository;
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

}