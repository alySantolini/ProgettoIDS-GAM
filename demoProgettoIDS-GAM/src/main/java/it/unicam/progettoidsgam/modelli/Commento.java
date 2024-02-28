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

    private String tipologia;
    private String titolo;
    private String descrizione;
    private static int idCOMPrecedente;


    public Commento(String descrizione,String titolo,String tipologia,String piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.tipologia=tipologia;
        setIdCommento();
    }

    public Commento(){
    }

    @Override
    public void creazione() {
        System.out.println("Creato");
    }

    public String getIdCommento() {
        return super.getIdElemento();
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
