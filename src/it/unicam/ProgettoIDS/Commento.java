package it.unicam.ProgettoIDS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//DA SISTEMARE
public class Commento extends Elemento{

    private String idCommento;
    private String tipologia;
    private String titolo;
    private String testo;
    private File immagine;
    private static int idCOMPrecedente;

    public Commento(File immagine,String descrizione, String titolo, String tipologia,PI piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.immagine=immagine;
        this.titolo=titolo;
        this.tipologia=tipologia;
        setIdCommento();
    }

    public Commento(String descrizione,String titolo,String tipologia,PI piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.titolo=titolo;
        this.tipologia=tipologia;
        setIdCommento();
    }

    private void setIdCommento(){
        super.setIdElemento("COM",idCOMPrecedente);
        idCOMPrecedente+=1;
    }
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void visualizza() throws IOException {
        if (this.immagine != null) {
            System.out.println(this.getIdElemento() + this.getTitolo() + this.getTipologia());
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
        System.out.println(this.getIdElemento() + this.getTitolo() + this.getTipologia());
    }

}
