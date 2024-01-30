package it.unicam.progettoidsgam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PIRepository extends JpaRepository<PI, String> {
    //Optional <PI> findByTitle(String titolo);
}