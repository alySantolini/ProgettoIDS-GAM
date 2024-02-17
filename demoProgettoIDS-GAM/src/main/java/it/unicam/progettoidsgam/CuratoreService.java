package it.unicam.progettoidsgam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static it.unicam.progettoidsgam.Curatore.elementiCuratore;

@Service
public class CuratoreService {

    private final CuratoreRepository curatoreRepository;

    private final SegnalazioneRepository segnalazioneRepository;
    private final PIRepository piRepository;
    private ElementiCuratoreRepository <Elemento> elementiCuratoreRepository;
    @Autowired
    public CuratoreService(ElementiCuratoreRepository<Elemento> elementiCuratoreRepository,CuratoreRepository curatoreRepository,SegnalazioneRepository segnalazioneRepository,PIRepository piRepository) {
        this.elementiCuratoreRepository=elementiCuratoreRepository;
        this.curatoreRepository =curatoreRepository;
        this.segnalazioneRepository=segnalazioneRepository;
        this.piRepository=piRepository;
    }

    public void salva() {
        Curatore curatore = new Curatore("Nome", "Cognome", "nickname" ) ;
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
    public ResponseEntity<Object> getSegnalazione(String idSegnalazione) {
        Optional<Segnalazione> segnalazione = segnalazioneRepository.findById(idSegnalazione);
        if (segnalazione != null) {
            return new ResponseEntity<>(segnalazione, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
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
            piRepository.deleteById(idElementoAssociato);
        }else{
        elementiCuratoreRepository.deleteById(idElementoAssociato);
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

            elementiCuratoreRepository.save(e);
         return new ResponseEntity<>(e,HttpStatus.OK);
    }
}