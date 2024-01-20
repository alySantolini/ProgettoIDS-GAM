package it.unicam.ProgettoIDS;

public class Turista extends Utente{

    private String idTurista;
    private String nickname;
    private static int idTUPrecedente;

    public Turista(String nickname) {
        super(nickname);
        setIdTurista();
    }


    public String getIdTurista() {
        return idTurista;
    }

    private void setIdTurista() {
       super.setIdUtente("T",idTUPrecedente);
        idTUPrecedente +=1;
    }
    public int getIdPrecedente() {
        return idTUPrecedente;
    }



}
