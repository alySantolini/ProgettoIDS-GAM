package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Commento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentoRepository extends JpaRepository<Commento, String>{

    Optional<Commento> findByTitolo(String titolo);

    Optional<Commento> findFirstByOrderByIdElementoDesc();
}
