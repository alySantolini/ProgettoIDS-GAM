package it.unicam.progettoidsgam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratoreRepository extends JpaRepository<Curatore,String> {
}