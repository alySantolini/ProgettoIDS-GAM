package it.unicam.progettoidsgam;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//DA SISTEMARE
@Entity
public class PI {
    @Id
    private String idPI;
    //private static List<Elemento> lCPI=new ArrayList<>();
    private String tipologia;
    private float longitudine;
    private float latitudine;
    private String descrizione;
    @Column(name = "titolo")
    private String titolo;
    private static int idPIPrecedente;

    public PI(String descrizione, String titolo, String tipologia, float longitudine, float latitudine) {
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

    public float getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(float longitudine) {
        this.longitudine = longitudine;
    }

    public float getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(float latitudine) {
        this.latitudine = latitudine;
    }

    public void setTipologia(String tipologia) {
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

    public String getTipologia() {
        return tipologia;
    }

    public String getIdPI() {
        return idPI;
    }

    /*  public void aggiungi(Elemento e){
          lCPI.add(e);
      }
      public List<Elemento> getLista(){
          return this.lCPI;
      }
      public void visualizzaLista() throws IOException {
          for(Elemento e : lCPI){
              e.visualizza();
          }
      }*/
    public void visualizza() throws IOException {
        if (this.getIdPI()!=null){
            System.out.println(this.getTitolo()+this.getDescrizione()+this.longitudine+this.latitudine);
        }else{
            System.out.println("Il PI non esiste");
        }
    }

}

