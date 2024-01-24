package it.unicam.ProgettoIDS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//DA SISTEMARE
public class PI extends Elemento{
    private String idPI;
    private static List<Elemento> lCPI=new ArrayList<>();
    private String tipologia;
    private String longitudine;
    private String latitudine;
    private static int idPIPrecedente;

    public PI(String descrizione, String titolo,String tipologia, String longitudine, String latitudine) {
        super(descrizione,titolo,null);
        this.longitudine=longitudine;
        this.latitudine=latitudine;
        this.tipologia=tipologia;
        setIdPI();
    }
    private void setIdPI(){
        super.setIdElemento("PI", idPIPrecedente);
        idPIPrecedente+=1;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getTipologia() {
        return tipologia;
    }

    public String getIdPI() {
        return idPI;
    }

    public void aggiungi(Elemento e){
        lCPI.add(e);
    }
    public List<Elemento> getLista(){
        return this.lCPI;
    }
    public void visualizzaLista() throws IOException {
        for(Elemento e : lCPI){
            e.visualizza();
        }
    }
    public void visualizza() throws IOException {
        if (super.getIdElemento()!=null){
            System.out.println(this.getTitolo()+this.getDescrizione()+this.longitudine+this.latitudine);
        }else{
            System.out.println("Il PI non esiste");
        }
    }
}

