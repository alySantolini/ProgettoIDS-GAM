package it.unicam.progettoidsgam.repository;


import it.unicam.progettoidsgam.modelli.Turista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TuristaRepository extends JpaRepository<Turista, String> {
    Optional<Turista> findByNickname(String nickname);
}
