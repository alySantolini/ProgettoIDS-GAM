package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

public class Contest {
    private String tipologia;
    private String titolo;
    private String descrizione;
    private static int idCONPrecedente ;
    private String idCreatore;
    private PI punti ;
    private String idContest;

    public Contest(PI pi, String tipologia, String titolo, String descrizione, String idAnimatore) {
        this.punti = pi;
        this.tipologia = tipologia;
        this.titolo = titolo;
        this.descrizione = descrizione;
        setIdContest();
        this.idCreatore = idAnimatore;
    }
    public PI getPunti() {
        return punti;
    }

    public void setPunti(PI punti) {
        this.punti = punti;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }




    private void setIdContest (){
        idContest = "CON"+idCONPrecedente;
        idCONPrecedente = idCONPrecedente + 1;

    }
    public String getId(){
        return idContest;
    }
}