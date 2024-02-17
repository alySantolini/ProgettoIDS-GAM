package it.unicam.progettoidsgam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EsperienzaRepository extends JpaRepository<Esperienza, String> {
    Optional<Esperienza> findByTitolo(String titolo);
}

