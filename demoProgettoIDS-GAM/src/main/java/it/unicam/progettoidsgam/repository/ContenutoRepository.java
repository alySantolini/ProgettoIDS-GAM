package it.unicam.progettoidsgam.repository;


import it.unicam.progettoidsgam.modelli.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, String> {
Optional<Contenuto> findByTitolo(String titolo);
Optional<Contenuto> findFirstByOrderByIdElementoDesc();

}

