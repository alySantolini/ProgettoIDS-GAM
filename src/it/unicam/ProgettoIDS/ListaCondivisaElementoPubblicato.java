/*package it.unicam.ProgettoIDS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//DA SISTEMARE
public class ListaCondivisaElementoPubblicato { //uguale alla LCE, mi serviva un posto dove indicare la presenza degli elementi pubblicati
    private List<Elemento> lista = new ArrayList<>(); // per buttarli giù dopouna eventuale segnalazione
    public void aggiungiElemento(Elemento elemento,Contributore contributore, Animatore animatore,Curatore curatore){
        if(contributore ==null && curatore == null && animatore==null){
            return;
        }
        lista.add(elemento);
    }
    public void visualizza() throws IOException {
        if(lista.isEmpty()){
            System.out.println("è vuota");
        }else {
            for (Elemento c : lista) {
                c.visualizza();
            }
        }
    }

    public List<Elemento> getLista(){
       return this.lista;
    }
    public void rimuoviElemento(Elemento elemento,Curatore curatore){
        if (curatore != null){
            lista.remove(elemento);
        }
    }

    public void rimuoviEC(Elemento e){
        lista.remove(e);
    }

    public int size(){
        return lista.size();
    }

    public Elemento getElementoFromId(String idElemento){
        for(Elemento e : lista){
            if(e.getIdElemento().equals(idElemento)){
                return e;
            }
        }
        return null;
    }
}

 */