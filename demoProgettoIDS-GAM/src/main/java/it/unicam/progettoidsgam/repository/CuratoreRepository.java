package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Curatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratoreRepository extends JpaRepository<Curatore,String> {
}