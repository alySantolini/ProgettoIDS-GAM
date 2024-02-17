package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ContenutoService {

    private final ContenutoRepository contenutoRepository;
    private final PIRepository piRepository;

    @Autowired
    public ContenutoService(ContenutoRepository elementoRepository, PIRepository piRepository) throws IOException {
        this.contenutoRepository =elementoRepository;
        this.piRepository=piRepository;
    }


    public ResponseEntity<Object> getContenuti(){
        return new ResponseEntity<>(contenutoRepository.findAll(), HttpStatus.OK);
    }

    public Contenuto addNewContenuto(Contenuto co) throws IOException {
        Optional<Contenuto> co1= contenutoRepository.findById(co.getIdContenuto());
        Optional<PI> piOptional = piRepository.findByTitolo(co.getPiRiferimento());
        if (piOptional.isEmpty()) {
            throw new ResourceAlreadyExistsException("PI con ID " + co.getPiRiferimento() + " non trovato.");
        }
        if(co1.isPresent()){
            throw new ResourceAlreadyExistsException("CO: " +co.getTitolo()+co.getDescrizione()+co.getPiRiferimento()+" esiste già");
        }
        co.setIdContenuto();
        return contenutoRepository.save(co);
    }


    public ContenutoRepository getRepository() {
        return contenutoRepository;}
}