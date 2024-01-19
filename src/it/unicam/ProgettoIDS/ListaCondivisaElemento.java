package it.unicam.ProgettoIDS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ListaCondivisaElemento {
    private List<Contenuto> lista = new ArrayList<>();
    public void aggiungiElemento(Contenuto elemento,Contributore contributore,TuristaAutenticato turista){
        if(contributore ==null && turista == null){
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

    /*public Elemento get(int i){
        return lista.get(i);
    }
*/
    public Contenuto getElementoFromId(String idElemento){
        for(Contenuto e : lista){
            if(e.getIdContenuto().equals(idElemento)){
                return e;
            }
        }
        return null;
    }
}