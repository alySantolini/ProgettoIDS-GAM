package it.unicam.ProgettoIDS;
public class Segnalazione {

    private String idSegnalazione;
    private String descrizione;
    private int idPrecedente=000;

    public Segnalazione(String idSegnalazione, String descrizione) {
        this.descrizione = descrizione;
    }
}
