package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.modelli.*;
import it.unicam.progettoidsgam.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static it.unicam.progettoidsgam.modelli.Curatore.elementiCuratore;
import static it.unicam.progettoidsgam.modelli.Curatore.piCuratore;

import java.util.Optional;

@Service
public class CuratoreService {

    private final CuratoreRepository curatoreRepository;

    private final SegnalazioneRepository segnalazioneRepository;
    private final PIRepository piRepository;
    private final ElementiRepository<Elemento> elementiRepository;

    private final ContestRepository contestRepository;
    @Autowired
    public CuratoreService(ElementiRepository<Elemento> elementiRepository, CuratoreRepository curatoreRepository, SegnalazioneRepository segnalazioneRepository, PIRepository piRepository,ContestRepository contestRepository) {
        this.elementiRepository = elementiRepository;
        this.curatoreRepository =curatoreRepository;
        this.segnalazioneRepository=segnalazioneRepository;
        this.piRepository=piRepository;
        this.contestRepository = contestRepository;
    }

    public void salva() {
        Curatore curatore = new Curatore("Nome", "Cognome", "curatore" ) ;
        // Imposta altri attributi se necessario
        curatore.setIdCuratore();
        curatoreRepository.save(curatore);
    }
    public boolean authenticate(String nickname, String id) {
        Optional<Curatore> curatoreOptional = curatoreRepository.findById(id);
        if (curatoreOptional.isPresent()) {
            Curatore curatore = curatoreOptional.get();
            if (nickname.equals(curatore.getNickname()) && id.equals(curatore.getIdCuratore())) {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity<Object> getLista() {
        for (Elemento e: elementiCuratore) {
            System.out.println(e);
        }
        return new ResponseEntity<>(elementiCuratore, HttpStatus.OK);
    }

    public ResponseEntity<Object> getPI() {
        for (PI pi: piCuratore) {
            System.out.println(pi);
        }
        return new ResponseEntity<>(piCuratore, HttpStatus.OK);
    }
    public ResponseEntity<Object> gestisciSegnalazione(String idSegnalazione){
        Optional<Segnalazione> segnalazioneOptional = segnalazioneRepository.findById(idSegnalazione);
        eliminaElementoAssociato( segnalazioneOptional.get());
        if(segnalazioneOptional.isPresent()){
            segnalazioneRepository.delete(segnalazioneOptional.get());
            return new ResponseEntity<>(segnalazioneOptional,HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    public void eliminaElementoAssociato(Segnalazione segnalazione) {
        String idElementoAssociato = segnalazione.getIdElemento();
        if(piRepository.existsById(idElementoAssociato)){
            eliminaElementi(idElementoAssociato);
            piRepository.deleteById(idElementoAssociato);
        }if(elementiRepository.existsById(idElementoAssociato)){
            elementiRepository.deleteById(idElementoAssociato);
        }else{contestRepository.deleteById(idElementoAssociato);

        }
    }

    public ResponseEntity<Object> autorizzaPI(PI pi) {
        if (pi != null) {
            piRepository.save(pi);
            return new ResponseEntity<>(pi, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> autorizzaElemento(Elemento e) {
        elementiRepository.save(e);
        return new ResponseEntity<>(e,HttpStatus.OK);
    }
    public void eliminaElementi(String idPi){
        String titolo = piRepository.findById(idPi).get().getTitolo();
        for (Elemento e: elementiRepository.findAll()) {
            if(e.getPiRiferimento().equals(titolo)){
                elementiRepository.delete(e);
            }
        }
        for(Contest c : contestRepository.findAll()){
            if(c.getPiRiferimento().equals(titolo)){
                contestRepository.delete(c);
            }
        }
    }
}