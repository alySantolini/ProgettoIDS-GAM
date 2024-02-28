package it.unicam.progettoidsgam.service;

import it.unicam.progettoidsgam.eccezioni.ResourceAlreadyExistsException;
import it.unicam.progettoidsgam.modelli.Contributore;
import it.unicam.progettoidsgam.modelli.Turista;
import it.unicam.progettoidsgam.repository.TuristaRepository;
import it.unicam.progettoidsgam.repository.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class TuristaService {
    private final TuristaRepository turistaRepository;
    private final UtentiRepository<Turista> utentiRepository;

    @Autowired
    public TuristaService(UtentiRepository<Turista> utentiRepository,TuristaRepository turistaRepository) {
        this.turistaRepository=turistaRepository;
        this.utentiRepository=utentiRepository;
    }

    public void salvaTuristaIniziale() {
        Turista turista= new Turista("turistaA", true);
        Turista turista1=new Turista("turista",false);
        utentiRepository.save(turista);
        utentiRepository.save(turista1);
    }

    public boolean authenticate(String nickname, String id) {
        Optional<Turista> turistaOptional = turistaRepository.findById(id);
        if (turistaOptional.isPresent()) {
            Turista turista = turistaOptional.get();
            if (nickname.equals(turista.getNickname()) && id.equals(turista.getIdTurista())) {
                return true;
            }
        }
        return false;
    }
    public Turista addNewTurista(Turista turista) throws IOException {
        Optional<Turista> turista1=turistaRepository.findById(turista.getIdTurista());
        Optional<Turista> turista2=turistaRepository.findByNickname(turista.getNickname());
        if(turista1.isPresent() || turista2.isPresent()){
            throw new ResourceAlreadyExistsException("Turista: " +turista.getNickname()+" esiste già");
        }
        turista.setIdTurista();
        return utentiRepository.save(turista);
    }
    public ResponseEntity<Object> getTurista(String idUtente) {
        Optional<Turista> turista = turistaRepository.findById(idUtente);
        if (turista != null) {
            return new ResponseEntity<>(turista, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> getTuristaByNickname(String nickname) {
        Optional<Turista> turista = turistaRepository.findByNickname(nickname);
        if (turista != null) {
            return new ResponseEntity<>(turista, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Object> cancellaTurista(String idUtente) {
        Optional<Turista> turista = turistaRepository.findById(idUtente);
        if (turista != null) {
            turistaRepository.delete(turista.get());
            return new ResponseEntity<>(turista, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
