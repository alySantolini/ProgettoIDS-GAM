package it.unicam.progettoidsgam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuratoreService {

    private final CuratoreRepository curatoreRepository;

    @Autowired
    public CuratoreService(CuratoreRepository curatoreRepository) {
        this.curatoreRepository =curatoreRepository;
       /* Contributore c1=new Contributore("alice","santolini","ali",true);
        contributoreRepository.save(c1);*/
    }

    public void salva() {
        Curatore curatore = new Curatore("Nome", "Cognome", "nickname");
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

}
