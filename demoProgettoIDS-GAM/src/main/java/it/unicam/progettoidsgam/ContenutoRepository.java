package it.unicam.progettoidsgam;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, String> {


}

