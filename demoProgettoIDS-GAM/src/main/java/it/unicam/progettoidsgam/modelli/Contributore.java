package it.unicam.progettoidsgam.modelli;

import jakarta.persistence.Entity;

@Entity
public class Contributore extends Utente {

    private String nome;
    private String cognome;
    private static int idCPrecedente;
    private boolean autorizzato;


    public Contributore(String nome, String cognome, String nickname, boolean autorizzato) {
        super(nickname);
        this.autorizzato = autorizzato;
        this.nome = nome;
        this.cognome = cognome;
        setIdContributore();
    }

    public Contributore() {
    }

    public String getIdContributore() {

        return super.getIdUtente();
    }

    public int getIdPrecedente() {
        return idCPrecedente;
    }


    public void setIdContributore() {
        if (autorizzato == true) {
            super.setIdUtente("CA", idCPrecedente);
        } else {
            super.setIdUtente("C", idCPrecedente);
        }
        idCPrecedente += 1;
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

    public boolean getAutorizzato() {
        return this.autorizzato;
    }

}