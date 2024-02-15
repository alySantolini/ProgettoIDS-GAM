package it.unicam.progettoidsgam;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, String> {
Optional<Contenuto> findByTitolo(String titolo);

}

