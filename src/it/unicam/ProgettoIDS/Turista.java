package it.unicam.ProgettoIDS;

public class Turista {

    private String idTurista;
    private String nickname;
    private int idPrecedente =000;

    public Turista(String nickname) {
        this.nickname = nickname;
    }

    public String getIdTurista() {
        return idTurista;
    }

    public void setIdTurista(String idTurista) {
        this.idTurista = "T"+idPrecedente;
        idPrecedente +=1;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getIdPrecedente() {
        return idPrecedente;
    }

    public Segnalazione creaSegnalazione(Elemento e){
        return null;
    }

}
