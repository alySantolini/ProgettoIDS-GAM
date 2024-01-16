import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaCondivisaElementoPubblicato { //uguale alla LCE, mi serviva un posto dove indicare la presenza degli elementi pubblicati
    private List<Elemento> lista = new ArrayList<>(); // per buttarli giù dopouna eventuale segnalazione
    public void aggiungiElemento(Elemento elemento,ContributoreAutorizzato contributoreA, Curatore curatore){
        if(contributoreA ==null && curatore == null){
            return;
        }
        lista.add(elemento);
    }
    public List<Elemento> getLista(){
        return new ArrayList<>(lista);
    }
    public void rimuoviElemento(Elemento elemento,Curatore curatore){
        if (curatore != null){
            lista.remove(elemento);
        }
    }
    public int size(){
        return lista.size();
    }

    public Elemento get(int i){
        return lista.get(i);
    }

    public Elemento getElementoFromId(String idElemento){
        for(int i = 0; i < lista.size(); i++){
            if(Objects.equals(idElemento, lista.get(i).getIdElemento())){
                return lista.get(i);
            }
        }
        return null;
    }
}