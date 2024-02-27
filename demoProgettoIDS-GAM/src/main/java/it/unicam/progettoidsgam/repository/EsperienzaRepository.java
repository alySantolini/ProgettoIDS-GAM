package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Esperienza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EsperienzaRepository extends JpaRepository<Esperienza, String> {
    Optional<Esperienza> findByTitolo(String titolo);
}

