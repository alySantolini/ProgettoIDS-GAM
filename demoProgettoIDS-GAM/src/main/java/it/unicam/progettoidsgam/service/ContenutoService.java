package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.modelli.Contest;
import it.unicam.progettoidsgam.repository.ContestRepository;
import it.unicam.progettoidsgam.modelli.Contenuto;
import it.unicam.progettoidsgam.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static it.unicam.progettoidsgam.modelli.Contest.elementiContest;
import static it.unicam.progettoidsgam.modelli.Curatore.elementiCuratore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class ContenutoService {


    private final ContenutoRepository contenutoRepository;
    private final ContestRepository contestRepository;

    @Autowired
    public ContenutoService(ContestRepository contestRepository,ContenutoRepository contenutoRepository) throws IOException {
        this.contenutoRepository =contenutoRepository;
        this.contestRepository=contestRepository;
    }


    public ResponseEntity<Object> getContenuti(){
        return new ResponseEntity<>(contenutoRepository.findAll(), HttpStatus.OK);
    }

    public Contenuto addContenutoMultimediale(String titolo, String descrizione, String piRiferimento, MultipartFile file) throws IOException {
        File newFile = new File("/C:/Users/Alice/IdeaProjects/unicam/src/main/resources"+file.getOriginalFilename()); //cambiare il pathname per visualizzare le immagini
        newFile.createNewFile();
        FileOutputStream fileOut=new FileOutputStream(newFile);
        fileOut.write(file.getBytes());
        fileOut.close();
        Contenuto contenuto = new Contenuto(file.getBytes(), titolo, descrizione, piRiferimento);
        contenuto.setImmagine(file.getBytes());
        contenuto.setTipologia("MULTIMEDIALE");
        return contenutoRepository.save(contenuto);
    }
    public Contenuto creaContenutoMultimediale(String titolo, String descrizione, String piRiferimento,MultipartFile file) throws IOException {
        File newFile = new File("/C:/Users/Alice/IdeaProjects/unicam/src/main/resources"+file.getOriginalFilename());
        newFile.createNewFile();
        FileOutputStream fileOut=new FileOutputStream(newFile);
        fileOut.write(file.getBytes());
        fileOut.close();
        Contenuto contenuto = new Contenuto(file.getBytes(), titolo, descrizione, piRiferimento);
        contenuto.setImmagine(file.getBytes());
        contenuto.setTipologia("MULTIMEDIALE");
        elementiCuratore.add(contenuto);
        return contenuto;
    }
    public ResponseEntity<Object> getContenutoByTitolo(String titolo) {
        Optional<Contenuto> contenuto = contenutoRepository.findByTitolo(titolo);
        if (contenuto != null) {
            return new ResponseEntity<>(contenuto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> partecipa(String titolo) {
        Optional<Contest> contest = contestRepository.findByTitolo(titolo);
        if(contest.isPresent()){
            Contenuto contenuto=getUltimoContenuto();
            elementiContest.add(contenuto);
            return new ResponseEntity<>(contenuto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   public Contenuto getUltimoContenuto() {
       Optional<Contenuto> ultimoContenuto = contenutoRepository.findFirstByOrderByIdElementoDesc();
       return ultimoContenuto.orElse(null);
   }
    public ContenutoRepository getRepository() {
        return contenutoRepository;}

}