package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContestRepository extends JpaRepository<Contest,String> {
    Optional<Contest> findByTitolo(String titolo);
}
