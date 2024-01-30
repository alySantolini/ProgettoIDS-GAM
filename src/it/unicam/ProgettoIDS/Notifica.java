/*package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

public abstract class Notifica {
    private String descrizione;
    private List<? extends Utente> destinatari = new ArrayList<>();
    private String idNotifica;
    private String idElemento;
    private Utente destinatario;

    public Notifica(String descrizione, List<? extends Utente> destinatari, String idElemento) {
        this.descrizione = descrizione;
        this.destinatari = destinatari;
        this.idElemento = idElemento;
    }

    public Notifica(String descrizione, Utente destinatario, String idElemento) {
        this.descrizione = descrizione;
        this.destinatario = destinatario;
        this.idElemento = idElemento;
        //aggiunta(destinatario)
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }

    public String getIdNotifica() {
        return idNotifica;
    }

    public void setIdNotifica(String prefix, int idPrecedente) {

        this.idNotifica = prefix + idPrecedente;
    }
    //public void aggiunta(Utente u){ u.getListaNotifiche.add(this);


    public void visualizza(){
        if (idNotifica!=null){
            System.out.println(this.descrizione);
        }else{
            System.out.println("La notifica non esiste");
        }
    }
}

 */
