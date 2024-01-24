package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

public class Invito extends Notifica{
    private String idInvito;
    private static int idInvitoPrecedente;
    private String descrizione;
    private List<Contributore> destinatari = new ArrayList<>();
    private String idContest;

    public Invito(String descrizione, List<Contributore> destinatari, String idContest) {
        super(descrizione,destinatari,idContest);
        setIdInvito();
    }

    public String getIdInvito() {
        return idInvito;
    }

    private void setIdInvito() {
        super.setIdNotifica("I" , idInvitoPrecedente);
        idInvitoPrecedente+=1;
    }

    public List<Contributore> getDestinatari() {
        return destinatari;
    }

    public void setDestinatari(List<Contributore> destinatari) {
        this.destinatari = destinatari;
    }
}
