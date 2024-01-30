/*package it.unicam.ProgettoIDS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//DA SISTEMARE
public class ListaCondivisaNotifiche {
    private List<Notifica> lista=new ArrayList<>();

    public void aggiungiNotifica(Notifica notifica, Utente utente){
        if(utente==null){
            return;
        }
        lista.add(notifica);
    }

    public void getLista() throws IOException {
        if(lista.isEmpty()){
            System.out.println("è vuota");
        }else {
            for (Notifica s : lista) {
                s.visualizza();
            }
        }
    }

    public void rimuoviNotifica(Notifica segnalazione, Curatore curatore){
        if(curatore!= null){
            lista.remove(segnalazione);
        }
    }
    public int size(){
        return lista.size();
    }
    public Notifica getNotificaFromId(String idNotifica){
        for(Notifica s : lista){
            if (s.getIdNotifica().equals(idNotifica)) {
                return s;
            }
        }
        return null;
    }

}

 */

