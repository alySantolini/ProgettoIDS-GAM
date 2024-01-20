package it.unicam.ProgettoIDS;

import java.io.IOException;

public abstract class Elemento {
    private String idElemento;
    private String descrizione;
    private String titolo;
    private String Tipologia;
    private static int idPrecedente;
    private String prefix;

//culoculoculoculo
    public Elemento(String descrizione, String titolo,String tipologia) {
        this.descrizione = descrizione;
        this.titolo = titolo;
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

    public String getTipologia() {
        return Tipologia;
    }

    public void setTipologia(String tipologia) {
        Tipologia = tipologia;
    }

    public void setIdElemento(String prefix , int idPrecedente) {

        this.idElemento = prefix+idPrecedente;
    }
    public abstract void visualizza() throws IOException;
}

