package it.unicam.ProgettoIDS;

import java.util.List;

//DA SISTEMARE
public class Segnalazione extends Notifica{

    private String idSegnalazione;
    private String descrizione;
    private static int idSPrecedente;
    private String idElemento;


    public Segnalazione( String idElemento,String descrizione,Curatore destinatario) {
        super(descrizione,destinatario, idElemento);
        setIdSegnalazione();
    }

    public String getIdSegnalazione() {
        return idSegnalazione;
    }

    public void setIdSegnalazione(){
        super.setIdNotifica("S",idSPrecedente);
        idSPrecedente+=1;
    }

}
