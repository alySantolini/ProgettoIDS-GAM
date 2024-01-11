package it.unicam.ProgettoIDS;

import java.util.List;

public class Animatore {
    private String idAnimatore;
    private String nome;
    private String cognome;
    private static int idAPrecedente;

    public Animatore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        setIdAnimatore();
    }

    public String getIdAnimatore() {
        return idAnimatore;
    }

    private void setIdAnimatore() {
        this.idAnimatore = "A"+idAPrecedente;
        idAPrecedente +=1;
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

    public int getIdPrecedente() {
        return idAPrecedente;
    }

    public Contest creaContest(PI pi, String tipologia, String titolo, String descrizione, String idAnimatore){
        return new Contest (pi, tipologia, titolo, descrizione,idAnimatore);
    }
}
