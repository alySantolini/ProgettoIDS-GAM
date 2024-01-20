package it.unicam.ProgettoIDS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Esperienza extends Elemento {
    private String idEsperienza;
    private String tipologia;
    private String titolo;
    private String descrizione;
    private static int idEPrecedente; //indica l'id corrente
    private List<PI> listaPI;
    public Esperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI) {
        super(descrizione,titolo,listaPI.get(0));
        this.tipologia=tipologia;
        this.listaPI = listaPI;
        setIdEsperienza();
    }
    public void setIdEsperienza() {
        super.setIdElemento("E",idEPrecedente);
        idEPrecedente+=1;
    }

    public void setListaPI(List<PI> listaPI) {
        this.listaPI = listaPI;
    }

    public static int getIdEPrecedente() {
        return idEPrecedente;
    }

    public List<PI> getListaPI() {
        return listaPI;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
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
