package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtentiRepository<T extends Utente> extends JpaRepository<T, String> {
}
