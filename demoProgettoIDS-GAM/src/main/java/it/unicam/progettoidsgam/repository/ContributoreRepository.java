package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Contributore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContributoreRepository extends JpaRepository<Contributore, String> {
    Optional<Contributore> findByNickname(String titolo);
}