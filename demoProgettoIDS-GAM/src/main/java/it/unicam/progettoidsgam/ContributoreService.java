package it.unicam.progettoidsgam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ContributoreService {

    private final ContributoreRepository contributoreRepository;
    @Autowired
    public ContributoreService(ContributoreRepository contributoreRepository) {
        this.contributoreRepository=contributoreRepository;
       /* Contributore c1=new Contributore("alice","santolini","ali",true);
        contributoreRepository.save(c1);*/
    }

    public void salvaContributoreIniziale() {
        Contributore contributore = new Contributore("Nome", "Cognome", "nickname", true);
        // Imposta altri attributi se necessario
        contributore.setIdContributore();
        contributoreRepository.save(contributore);
    }
    public boolean authenticate(String nickname, String id) {
        Optional<Contributore> contributoreOptional = contributoreRepository.findById(id);
        if (contributoreOptional.isPresent()) {
            Contributore contributore = contributoreOptional.get();
            if (nickname.equals(contributore.getNickname()) && id.equals(contributore.getIdContributore())) {
                return true;
            }
        }
        return false;
    }

}
