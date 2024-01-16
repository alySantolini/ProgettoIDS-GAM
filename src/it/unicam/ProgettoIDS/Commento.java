package it.unicam.ProgettoIDS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Commento {


    private String idCommento;
    private String tipologia;
    private String titolo;
    private String testo;
    private File immagine;
    private static int idCOMPrecedente;

    public Commento(File immagine, String titolo, String tipologia) {
        this.immagine=immagine;
        this.titolo=titolo;
        this.tipologia=tipologia;
        setIdCommento();
    }

    public Commento(String titolo,String tipologia) {
        this.titolo=titolo;
        this.tipologia=tipologia;
        setIdCommento();
    }

    private void setIdCommento(){
        idCommento = "COM" + idCOMPrecedente;
        idCOMPrecedente+=1;
    }
    public String getIdCommento(){
        return idCommento;
    }
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public void visualizza() throws IOException {
        if (this.immagine != null) {
            System.out.println(this.getIdCommento() + this.getTitolo() + this.getTipologia());
            Image image = ImageIO.read(this.immagine);
            // Creazione di un frame e di un label per visualizzare l'immagine
            JFrame frame = new JFrame("Display Image Example");
            JLabel label = new JLabel(new ImageIcon(image));

            // Aggiunta del label al frame
            frame.getContentPane().add(label);

            // Impostazione delle dimensioni del frame
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        System.out.println(this.getIdCommento() + this.getTitolo() + this.getTipologia());
    }

}
