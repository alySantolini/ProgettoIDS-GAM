package it.unicam.progettoidsgam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementiCuratoreRepository<T extends Elemento> extends JpaRepository<T, String> {
}
