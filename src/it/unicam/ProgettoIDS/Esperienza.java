package it.unicam.ProgettoIDS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Esperienza {
    private String idEsperienza;
    private String tipologia;
    private String titolo;
    private String descrizione;
    private static int idEPrecedente; //indica l'id corrente
    private List<PI> listaPI;

    public Esperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI) {
        this.tipologia=tipologia;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.listaPI = listaPI;
        setIdEsperienza();
    }
    public void setIdEsperienza() {
        this.idEsperienza = "E"+idEPrecedente;
        idEPrecedente+=1;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setListaPI(List<PI> listaPI) {
        this.listaPI = listaPI;
    }

    public String getIdEsperienza() {
        return idEsperienza;
    }

    public String getTipologia() {
        return tipologia;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public static int getIdEPrecedente() {
        return idEPrecedente;
    }

    public List<PI> getListaPI() {
        return listaPI;
    }

    public void visualizza(){
        if (idEsperienza!=null){
            System.out.println(this.titolo+this.descrizione);
            for(PI puntoInteresse : this.listaPI){
                System.out.println(puntoInteresse);
            }
        }else{
            System.out.println("l'esperienza non esiste");
        }
    }

}
