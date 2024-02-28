package it.unicam.progettoidsgam.modelli;

import jakarta.persistence.Entity;
@Entity
public class Commento extends Elemento {

    private String tipologia;
    private static int idCOMPrecedente;


    public Commento(String descrizione,String titolo,String piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.tipologia="TESTUALE";
        setIdCommento();
    }

    public Commento(){
    }

    @Override
    public void creazione() {
        System.out.println("Commento creato");
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
