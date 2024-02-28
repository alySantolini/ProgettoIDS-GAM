package it.unicam.progettoidsgam.modelli;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Esperienza extends Elemento {

    private String tipologia;
    private static int idEPrecedente; //indica l'id corrente
    @ElementCollection
    private List<String> listaPI;

    public Esperienza(String tipologia, String titolo, String descrizione, List<String> listaPI) {
        super(descrizione,titolo,listaPI.get(0));
        this.tipologia=tipologia;
        this.listaPI = listaPI;
        setIdEsperienza();
    }

    public List<String> getListaPI() {
        return listaPI;
    }

    public Esperienza(){

    }
    public void setIdEsperienza() {
        super.setIdElemento("E",idEPrecedente);
        idEPrecedente+=1;
    }

    public String getIdEsperienza() {
        return super.getIdElemento();
    }

    public void setListaPI(List<String> listaPI) {
        this.listaPI = listaPI;
    }

    public static int getIdEPrecedente() {
        return idEPrecedente;
    }



    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @Override
    public void creazione() {
        System.out.println("Creato");
    }



}




