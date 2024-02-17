package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
        Contributore contributore1=new Contributore("ali","santolini","aliS",false);
        // Imposta altri attributi se necessario
        contributore.setIdContributore();
        contributore1.setIdContributore();
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
    public Contributore addNewContributore(Contributore contributore) throws IOException {
        Optional<Contributore> contributore1=contributoreRepository.findById(contributore.getIdContributore());
        if(contributore1.isPresent()){
            throw new ResourceAlreadyExistsException("Contributore: " +contributore.getNickname()+" esiste già");
        }
        contributore.setIdContributore();
        return contributoreRepository.save(contributore);
    }
}
