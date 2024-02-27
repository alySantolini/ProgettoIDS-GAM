package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Animatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimatoreRepository extends JpaRepository<Animatore,String> {
    Optional<Animatore> findByNickname(String nickname);
}
