package it.unicam.ProgettoIDS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaCondivisaElementoPubblicato { //uguale alla LCE, mi serviva un posto dove indicare la presenza degli elementi pubblicati
    private List<Contenuto> lista = new ArrayList<>(); // per buttarli giù dopouna eventuale segnalazione
    public void aggiungiElemento(Contenuto elemento,ContributoreAutorizzato contributoreA, Curatore curatore){
        if(contributoreA ==null && curatore == null){
            return;
        }
        lista.add(elemento);
    }
    public void getLista() throws IOException {
        if(lista.isEmpty()){
            System.out.println("è vuota");
        }else {
            for (Contenuto c : lista) {
                c.visualizza();
            }
        }
    }
    public void rimuoviElemento(Contenuto elemento,Curatore curatore){
        if (curatore != null){
            lista.remove(elemento);
        }
    }
    public int size(){
        return lista.size();
    }

    public Contenuto getElementoFromId(String idElemento){
        for(Contenuto e : lista){
            if(e.getIdContenuto().equals(idElemento)){
                return e;
            }
        }
        return null;
    }
}