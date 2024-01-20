package it.unicam.ProgettoIDS;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Contenuto extends Elemento{
    private String tipologia;
    private String descrizione;
    private String titolo;
    private File immagine;
    private String idContenuto;
    private static int idCOPrecedente;

    public Contenuto(File immagine, String titolo, String descrizione, String tipologia,PI piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.immagine=immagine;
        this.tipologia=tipologia;
        setIdContenuto();
    }
    public Contenuto(String titolo, String descrizione,String tipologia,PI piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.tipologia=tipologia;
        setIdContenuto();
    }
   // public String getIdContenuto() {
       // return idContenuto;
  //  }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    private void setIdContenuto() {
        super.setIdElemento("CO",idCOPrecedente);
        idCOPrecedente +=1;
    }

    public void visualizza() throws IOException {
        if (this.immagine != null) {
            System.out.println(this.getIdElemento() + this.getTitolo() + this.getDescrizione() + this.getTipologia());
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
        System.out.println(this.getIdElemento() + this.getTitolo() + this.getDescrizione() + this.getTipologia());
        }

}


