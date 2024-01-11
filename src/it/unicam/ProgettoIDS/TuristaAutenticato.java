package it.unicam.ProgettoIDS;

public class TuristaAutenticato {
    private String idTuristaAutenticato;
    private String nickname;
    private static int idTAPrecedente;

    public TuristaAutenticato(String nickname) {
        this.nickname = nickname;
        setIdTuristaAutenticato();
    }

    public String getIdTuristaAutenticato() {
        return idTuristaAutenticato;
    }

    private void setIdTuristaAutenticato() {
        this.idTuristaAutenticato = "TA"+idTAPrecedente;
        idTAPrecedente +=1;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Segnalazione creaSegnalazione(Elemento e){
        return null;
    }
    public void pubblicazioneCommento(Commento commento){

    }
}
