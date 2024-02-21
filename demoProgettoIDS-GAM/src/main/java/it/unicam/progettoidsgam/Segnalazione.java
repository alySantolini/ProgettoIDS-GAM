package it.unicam.progettoidsgam;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//DA SISTEMARE
@Entity
public class Segnalazione{
@Id
    private String idSegnalazione;
    private String descrizione;
    private static int idSPrecedente;
    private String idElemento;
    public Segnalazione( String idElemento,String descrizione) {
        this.idElemento=idElemento;
        this.descrizione=descrizione;
        setIdSegnalazione();
    }

    public Segnalazione() {

    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }

    public String getIdSegnalazione() {
        return idSegnalazione;
    }

    public void setIdSegnalazione(){
        idSegnalazione="S"+idSPrecedente;
        idSPrecedente+=1;
    }

}
