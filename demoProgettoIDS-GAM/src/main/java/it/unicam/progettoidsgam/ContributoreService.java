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
    }

    public void salvaContributoreIniziale() {
        Contributore contributore = new Contributore("Nome", "Cognome", "nickname", true);
        Contributore contributore1=new Contributore("ali","santolini","ali",false);
        // Imposta altri attributi se necessario
        contributoreRepository.save(contributore);
        contributoreRepository.save(contributore1);
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
