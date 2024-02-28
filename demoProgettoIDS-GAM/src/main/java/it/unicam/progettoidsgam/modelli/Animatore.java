package it.unicam.progettoidsgam.modelli;


import jakarta.persistence.Entity;

@Entity
public class Animatore extends Utente {

    private String nome;
    private String cognome;
    private static int idAPrecedente;


    public Animatore(String nome, String cognome, String nickname) {
        super(nickname);
        this.nome = nome;
        this.cognome = cognome;
        setIdAnimatore();
    }

    public Animatore() {

    }

    public String getIdAnimatore() {
        return super.getIdUtente();
    }

    public void setIdAnimatore() {
        super.setIdUtente("A", idAPrecedente);
        idAPrecedente += 1;
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
}