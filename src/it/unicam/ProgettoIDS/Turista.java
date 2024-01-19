package it.unicam.ProgettoIDS;

public class Turista {

    private String idTurista;
    private String nickname;
    private static int idTUPrecedente;

    public Turista(String nickname) {
        this.nickname = nickname;
        setIdTurista();
    }


    public String getIdTurista() {
        return idTurista;
    }

    private void setIdTurista() {
        this.idTurista = "T"+idTUPrecedente;
        idTUPrecedente +=1;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getIdPrecedente() {
        return idTUPrecedente;
    }

    public Segnalazione creaSegnalazione(ListaCondivisaSegnalazioni listaCondivisa, Contenuto e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdContenuto(),descrizione);
        listaCondivisa.aggiungiSegnalazione(segnalazione, null, null, this,null);
        return segnalazione;
    }

}
