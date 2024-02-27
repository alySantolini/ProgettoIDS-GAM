package it.unicam.progettoidsgam.repository;

import it.unicam.progettoidsgam.modelli.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtentiRepository<T extends Utente> extends JpaRepository<T, String> {
}
