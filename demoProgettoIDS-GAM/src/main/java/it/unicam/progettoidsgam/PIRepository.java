package it.unicam.progettoidsgam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PIRepository extends JpaRepository<PI, String> {
    Optional<PI> findByTitolo(String titolo);
}