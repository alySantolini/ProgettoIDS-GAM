package it.unicam.progettoidsgam.modelli;


import it.unicam.progettoidsgam.modelli.PI;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curatore extends Contributore {
    private String idCuratore;
    private String nome;
    private String cognome;
    private String nickname;
    public static List<PI> piCuratore=new ArrayList<>();
    public static List<Elemento> elementiCuratore=new ArrayList<>();
    public Curatore(String nome, String cognome, String nickname) {
        super(nome ,cognome , nickname,true);
        setIdCuratore();
    }

    public Curatore(){

    }

    public void setIdCuratore() {
        this.idCuratore = "CU001";
        super.setIdUtente("CU00",1);
    }

    public String getIdCuratore() {
        return super.getIdUtente();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

}


