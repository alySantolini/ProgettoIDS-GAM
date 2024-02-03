package it.unicam.progettoidsgam;

import jakarta.persistence.*;

import java.io.IOException;

//DA SISTEMARE
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Elemento {
    @Id
    private String idElemento;
    private String descrizione;
    private String titolo;

    private String piRiferimento;

    public Elemento(String descrizione, String titolo,String piRiferimento) {
        this.descrizione = descrizione;
        this.piRiferimento=piRiferimento;
        this.titolo = titolo;
    }

    public Elemento(){

    }

    public String getPiRiferimento() {
        return piRiferimento;
    }

    public void setPiRiferimento(String piRiferimento) {
        this.piRiferimento = piRiferimento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getIdElemento(){ // aggiunti sennò dava errore non ho idea se sia giusto o no al momento, come scheletro dovrebbe andare bene per i vari metodi
        return idElemento;
    }

    public void setIdElemento(String prefix , int idPrecedente) {
        this.idElemento = prefix+idPrecedente;
    }
   // public abstract void visualizza() throws IOException;
}



