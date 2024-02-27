package it.unicam.progettoidsgam.modelli;

import it.unicam.progettoidsgam.modelli.Elemento;
import jakarta.persistence.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

//DA SISTEMARE
@Entity
public class Commento extends Elemento {

    private String idCommento;
    private String tipologia;
    private String titolo;
    private String testo;
    private static int idCOMPrecedente;


    public Commento(String descrizione,String titolo,String tipologia,String piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.titolo=titolo;
        this.tipologia=tipologia;
        setIdCommento();
    }

    public Commento(){
    }

    public String getIdCommento() {
        return idCommento;
    }

    public void setIdCommento(){
        super.setIdElemento("COM",idCOMPrecedente);
        idCOMPrecedente+=1;
    }
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }



}
