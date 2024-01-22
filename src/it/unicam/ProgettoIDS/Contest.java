package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

//DA SISTEMARE
public class Contest extends Elemento{
    private String tipologia;
    private String titolo;
    private String descrizione;
    private Animatore creatore;
    private String idContest;
    private static int idCONPrecedente ;

    private Invito invito;

    public Contest(String descrizione,String titolo, String tipologia, PI piRiferimento,  Animatore creatore){
        super(descrizione,titolo,piRiferimento);
        this.creatore = creatore;
        this.tipologia=tipologia;
        setIdContest();
    }
    public Contest(String descrizione,String titolo, String tipologia, PI piRiferimento,  Animatore creatore, Invito invito){
        super(descrizione,titolo,piRiferimento);
        this.creatore = creatore;
        this.tipologia=tipologia;
        this.invito = invito;
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
    public Animatore getCreatore() {
        return creatore;
    }
    public void visualizza(){
        if (idContest!=null){
            System.out.println(this.titolo+this.descrizione);
        }else{
            System.out.println("Il contest non esiste");
        }
    }
}