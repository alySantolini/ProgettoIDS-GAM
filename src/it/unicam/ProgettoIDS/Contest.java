package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

public class Contest extends Elemento{
    private String tipologia;
    private String titolo;
    private String descrizione;
    private String idCreatore;
    private String idContest;
    private static int idCONPrecedente ;

    public Contest(String descrizione,String titolo, String tipologia, PI piRiferimento,  String idAnimatore){
        super(descrizione,titolo,piRiferimento);
        this.idCreatore = idAnimatore;
        this.tipologia=tipologia;
        setIdContest();
    }
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }


    private void setIdContest (){
        super.setIdElemento("CON" , idCONPrecedente);
        idCONPrecedente = idCONPrecedente + 1;

    }
    public void visualizza(){
        if (idContest!=null){
            System.out.println(this.titolo+this.descrizione);
        }else{
            System.out.println("Il contest non esiste");
        }
    }
}