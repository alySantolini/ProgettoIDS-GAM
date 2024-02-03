package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.PI;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

//DA SISTEMARE
@Entity
public class Esperienza extends Elemento {

    private String tipologia;
    private static int idEPrecedente; //indica l'id corrente
    private  List<String> listaPI;
    public Esperienza(String tipologia, String titolo, String descrizione, List<String> listaPI) {
        super(descrizione,titolo,listaPI.get(0));
        this.tipologia=tipologia;
         this.listaPI = listaPI;
        setIdEsperienza();
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

   /* public static List<String> getListaPI() {
        return listaPI;
    }*/

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

   /* public void visualizza(){
        if (idEsperienza!=null){
            System.out.println(this.titolo+this.descrizione);
            for(PI puntoInteresse : this.listaPI){
                System.out.println(puntoInteresse);
            }
        }else{
            System.out.println("l'esperienza non esiste");
        }
    }
 */


}


