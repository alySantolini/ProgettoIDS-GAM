package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class SegnalazioneService {

    private final SegnalazioneRepository segnalazioneRepository;

    @Autowired
    public SegnalazioneService( SegnalazioneRepository segnalazioneRepository) throws IOException {
        this.segnalazioneRepository =segnalazioneRepository;
    }
    public Segnalazione addNewSegnalazione(Segnalazione segnalazione) throws IOException {
        Optional<Segnalazione> so1= segnalazioneRepository.findById(segnalazione.getIdSegnalazione());
        if(so1.isPresent()){
            throw new ResourceAlreadyExistsException("S: " + segnalazione.getIdSegnalazione()+" esiste già");
        }
        segnalazione.setIdSegnalazione();
            return segnalazioneRepository.save(segnalazione);
    }
    public SegnalazioneRepository getRepository() {
        return segnalazioneRepository;}
}