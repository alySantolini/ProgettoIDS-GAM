package it.unicam.progettoidsgam.modelli;


import it.unicam.progettoidsgam.enumerazioni.TipologiaPI;
import jakarta.persistence.*;

import java.io.IOException;

@Entity
public class PI {
    @Id
    private String idPI;
    @Enumerated(EnumType.STRING)
    private TipologiaPI tipologia;
    private double longitudine;
    private double latitudine;
    private String descrizione;
    @Column(name = "titolo")
    private String titolo;
    private static int idPIPrecedente;

    public PI(String descrizione, String titolo, TipologiaPI tipologia, double longitudine, double latitudine) {
        this.descrizione=descrizione;
        this.titolo=titolo;
        this.longitudine=longitudine;
        this.latitudine=latitudine;
        this.tipologia=tipologia;
        setIdPI();
    }

    public PI() {

    }


    public void setIdPI(){
        idPI="PI"+idPIPrecedente;
        idPIPrecedente+=1;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public void setTipologia(TipologiaPI tipologia) {
        this.tipologia = tipologia;
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

    public TipologiaPI getTipologia() {
        return tipologia;
    }

    public String getIdPI() {
        return idPI;
    }


}

