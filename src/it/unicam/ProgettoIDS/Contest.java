package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

public class Contest extends Elemento{
    private String tipologia;
    private String titolo;
    private String descrizione;
    private String idCreatore;
    private PI punti ;
    private String idContest;
    private static int idCONPrecedente ;

    public Contest(String descrizione,String titolo, String tipologia, PI pi,  String idAnimatore){
        super(descrizione,titolo,tipologia);
        this.punti = pi;
        setIdContest();
        this.idCreatore = idAnimatore;
    }
    public PI getPunti() {
        return punti;
    }

    public void setPunti(PI punti) {
        this.punti = punti;
    }

    private void setIdContest (){
        super.setIdElemento("CON" , idCONPrecedente);
        idCONPrecedente = idCONPrecedente + 1;

    }
    public String getId(){
        return idContest;
    }

    public void visualizza(){
        if (idContest!=null){
            System.out.println(this.titolo+this.descrizione);
        }else{
            System.out.println("Il contest non esiste");
        }
    }
}