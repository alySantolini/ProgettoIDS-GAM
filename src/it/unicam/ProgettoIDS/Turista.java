package it.unicam.ProgettoIDS;

public class Turista {

    private String idTurista;
    private String nickname;
    private static int idPrecedente;

    public Turista(String nickname) {
        this.nickname = nickname;
        setIdTurista();
    }


    public String getIdTurista() {
        return idTurista;
    }

    public void setIdTurista() {
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
