package it.unicam.ProgettoIDS;

public class Commento {


    private String idCommento;
    private String tipologia;
    private String titolo;
    private String testo;
    private static int idCOMPrecedente;

    public Commento(String tipologia, String titolo, String testo) {
        this.tipologia = tipologia;
        this.titolo = titolo;
        this.testo = testo;
        setIdCommento();
    }

    private void setIdCommento(){
        idCommento = "COM" + idCOMPrecedente;
        idCOMPrecedente+=1;
    }
    public String getIdCommento(){
        return idCommento;
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

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
}
