package it.unicam.progettoidsgam.modelli;

import jakarta.persistence.Entity;

@Entity
public class Turista extends Utente {

    private String nickname;
    private static int idTUPrecedente;
    private boolean autenticato;
    public Turista(String nickname,boolean autenticato) {
        super(nickname);
        this.autenticato=autenticato;
        setIdTurista();
    }
    public Turista(){
    }
    public String getIdTurista() {
        return super.getIdUtente();
    }

    public void setIdTurista() {
        if(autenticato) {
            super.setIdUtente("TA",idTUPrecedente);
            idTUPrecedente += 1;
        }else{
            super.setIdUtente("T",idTUPrecedente);
        idTUPrecedente +=1;}
    }

    public int getIdPrecedente() {
        return idTUPrecedente;
    }

   /* public void creaSegnalazione( Contenuto e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdContenuto(),descrizione);

    }
    public void creaCommento( String descrizione, String titolo, String tipologia, String piRiferimento){

        Commento commento=new Commento(descrizione ,titolo,"commento",piRiferimento);
        pubblicazioneCommento(commento);
    }
    public void pubblicazioneCommento(Commento commento){
        System.out.println("Il commento "+commento.getTitolo()+" è stato pubblicato");
    }*/
}
