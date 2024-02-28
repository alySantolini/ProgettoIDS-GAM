package it.unicam.progettoidsgam.modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

@Entity
public class Contenuto extends Elemento {

    private String tipologia;
    @Lob
    private byte[] immagine;
    private static int idCOPrecedente;

    public Contenuto(byte[] immagine, String titolo, String descrizione, String piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.immagine=immagine;
        setIdContenuto();
    }

    public Contenuto() {
    }

    @Override
    public void creazione() {
        System.out.println("Contenuto creato");
    }

    public String getIdContenuto() {
        return super.getIdElemento();
    }

    public void setIdContenuto() {
        super.setIdElemento("CO",idCOPrecedente);
        idCOPrecedente +=1;
    }
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public byte[] getImmagine() {
        return immagine;
    }

    public void setImmagine(byte[] immagine) {
        this.immagine = immagine;
    }
}


