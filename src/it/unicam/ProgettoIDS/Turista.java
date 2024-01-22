package it.unicam.ProgettoIDS;

//DA SISTEMARE
public class Turista extends Utente{

    private String idTurista;
    private String nickname;
    private static int idTUPrecedente;


    public Turista(String nickname,ListaCondivisaNotifiche listaPersonale) {
        super(nickname,listaPersonale);
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
