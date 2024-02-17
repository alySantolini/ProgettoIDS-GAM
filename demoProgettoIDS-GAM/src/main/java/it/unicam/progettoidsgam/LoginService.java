package it.unicam.progettoidsgam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final ContributoreService contributoreService;
    private final CuratoreService curatoreService;

    @Autowired
    public LoginService(ContributoreService contributoreService, CuratoreService curatoreService) {
        this.contributoreService = contributoreService;
        this.curatoreService = curatoreService;
    }

    public boolean authenticate(String username, String password) {
        // Verifica se le credenziali appartengono a un contributore o a un curatore
        return contributoreService.authenticate(username, password) || curatoreService.authenticate(username, password);
    }
}