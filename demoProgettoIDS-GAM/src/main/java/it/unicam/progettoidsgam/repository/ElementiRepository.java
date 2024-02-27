package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElementiRepository<T extends Elemento> extends JpaRepository<T, String> {
    Optional<Elemento> findByTitolo(String titolo);
}
