import it.unicam.ProgettoIDS.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.time.Duration;

//DA SISTEMARE
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//DA FARE ITINERARIO, OSM,TIPOLOGIA PI, database utenti, lista personale notifiche, sistemare tutti i visualizza, aggiungicontest
public class Main {
    public static void main(String[] args) throws IOException {
        // Press Alt+Invio with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        ListaCondivisaElemento listaCondivisa = new ListaCondivisaElemento();
        ListaCondivisaElementoPubblicato lCeP= new ListaCondivisaElementoPubblicato();
        //ListaCondivisaNotifiche listaSegnalazione= new ListaCondivisaNotifiche();
       // File file = new File ("/C:/Users/Alice/Desktop/perlana.jpg/");
        // Image image = ImageIO.read(file);
        Curatore curatore =new Curatore("gino","paoli","ginoP01",new ListaCondivisaNotifiche() );
        Contributore contributore = new Contributore("alberto","ciao","albiCiao",false,new ListaCondivisaNotifiche());
        PI pi= curatore.creaPI("piazza","piazza cavour","storico","10","11");
        curatore.pubblicazionePI(lCeP,pi);
        Contenuto c =contributore.creaContenuto(null,"perlana","lavatoCon",pi);
        contributore.richiestaAutorizzazione(listaCondivisa,c);
        curatore.controlloLista(listaCondivisa);
        curatore.autorizzazione(lCeP,listaCondivisa,c.getIdElemento());
        curatore.controlloLista(listaCondivisa);
      /*  Segnalazione s=contributore.creaSegnalazione(c,"contenuto errato",curatore);
        curatore.gestioneSegnalazione(lCeP,s.getIdNotifica());*/
       // contributore.creaContenuto(file,"perlana","lavatoCon").visualizza();
       // contributore.creaContenuto(null,"perlana","lavatoCon").visualizza();
        curatore.pubblicazioneContenuto(lCeP,null,"mammaCiao" ,"saluti",pi);
        contributore.ricercaPI(pi,lCeP);
       // Evento e= new Evento ("sagra del leone","leone",pi,Duration.ofSeconds(60) );
        curatore.pubblicazioneEvento(lCeP,"sagra del leone","leone",pi,Duration.ofSeconds(10));

    }
}
