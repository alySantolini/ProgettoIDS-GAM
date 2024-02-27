package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.PIRepository;
import it.unicam.progettoidsgam.PIService;
import it.unicam.progettoidsgam.modelli.Esperienza;
import it.unicam.progettoidsgam.repository.ElementiRepository;
import it.unicam.progettoidsgam.repository.EsperienzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;

import static it.unicam.progettoidsgam.modelli.Curatore.elementiCuratore;

@Service
public class EsperienzaService {
    private final EsperienzaRepository esperienzaRepository;
    private ElementiRepository<Esperienza> elementiRepository;
    private final PIRepository piRepository;

    @Autowired
    public EsperienzaService(PIService piService, PIRepository piRepository, EsperienzaRepository esperienzaRepository, ElementiRepository<Esperienza> elementiRepository){
        this.esperienzaRepository=esperienzaRepository;
        this.elementiRepository = elementiRepository;
        this.piRepository= piRepository;
    }
    public ResponseEntity<Object> getEsperienza(String titolo){
        Optional<Esperienza> esperienza = esperienzaRepository.findByTitolo(titolo);

        if (esperienza != null) {
            return new ResponseEntity<>(esperienza, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Esperienza addNewEsperienza(Esperienza esperienza) throws IOException {
        Optional<Esperienza> esperienza1=esperienzaRepository.findById(esperienza.getIdElemento());
        Optional<Esperienza> esperienza2=esperienzaRepository.findByTitolo(esperienza.getTitolo());
        for (String pi:esperienza.getListaPI()) {
            if(piRepository.findByTitolo(pi).isEmpty()){
                throw new ResourceAlreadyExistsException("i pi: " +esperienza.getListaPI()+" non esistono ");
            }
        }
        if( esperienza1.isPresent() || esperienza2.isPresent() ){
            throw new ResourceAlreadyExistsException("Esperienza: " +esperienza.getTitolo()+esperienza.getDescrizione()+esperienza.getTipologia()+" esiste già");
        }
        esperienza.setIdEsperienza();
        return elementiRepository.save(esperienza);
    }

    public Esperienza creaNewEsperienza(Esperienza e) throws IOException {
        Optional<Esperienza> e1= esperienzaRepository.findById(e.getIdElemento());
        for (String pi:e.getListaPI()) {
            if(piRepository.findByTitolo(pi).isEmpty()){
                throw new ResourceAlreadyExistsException("i pi: " +e.getListaPI()+" non esistono ");
            }
        }
        if(e1.isPresent()){
            throw new ResourceAlreadyExistsException("E: " +e.getTitolo()+e.getDescrizione()+e.getPiRiferimento()+" esiste già");
        }
        e.setIdEsperienza();
        elementiCuratore.add(e);
        return e;
    }

    public ResponseEntity<Object> getEsperienze(){
        return new ResponseEntity<>(esperienzaRepository.findAll(), HttpStatus.OK);
    }
}


