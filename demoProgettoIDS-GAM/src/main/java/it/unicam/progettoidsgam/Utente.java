package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.PI;
import jakarta.persistence.*;

import java.io.IOException;

//DA SISTEMARE
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utente {

    private String nickname;
    @Id
    private String idUtente;


    public Utente(String nickname) {
        this.nickname = nickname;
    }

    public Utente(){

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String prefix,int idPrecedente) {
        this.idUtente = prefix+idPrecedente;
    }

}

