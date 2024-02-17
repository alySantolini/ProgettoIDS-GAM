package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AnimatoreService {

    private final AnimatoreRepository animatoreRepository;
    @Autowired
    public AnimatoreService(AnimatoreRepository animatoreRepository) {
        this.animatoreRepository=animatoreRepository;
    }
   public void salvaAnimatoreIniziale() {
        Animatore animatore = new Animatore("Nome","Cognome","nickname2");
        animatoreRepository.save(animatore);
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
        if(animatore1.isPresent()){
            throw new ResourceAlreadyExistsException("animatore: " +animatore.getNickname()+" esiste già");
        }
        animatore.setIdAnimatore();
        return animatoreRepository.save(animatore);
    }
}
