package it.unicam.progettoidsgam.service;
import it.unicam.progettoidsgam.service.AnimatoreService;
import it.unicam.progettoidsgam.service.ContributoreService;
import it.unicam.progettoidsgam.service.CuratoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final ContributoreService contributoreService;
    private final CuratoreService curatoreService;
    private final AnimatoreService animatoreService;
    private final TuristaService turistaService;
    @Autowired
    public LoginService(ContributoreService contributoreService, CuratoreService curatoreService,AnimatoreService animatoreService,TuristaService turistaService) {
        this.contributoreService = contributoreService;
        this.curatoreService = curatoreService;
        this.animatoreService=animatoreService;
        this.turistaService=turistaService;
    }

    public boolean authenticate(String username, String password) {
        return contributoreService.authenticate(username, password) || curatoreService.authenticate(username, password)
                || animatoreService.authenticate(username,password)|| turistaService.authenticate(username,password);
    }
}