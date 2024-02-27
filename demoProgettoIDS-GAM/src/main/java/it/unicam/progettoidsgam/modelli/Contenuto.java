package it.unicam.progettoidsgam.modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

import java.io.File;

//DA SISTEMARE
@Entity
public class Contenuto extends Elemento {

    private String tipologia;
    @Lob
    private byte[] immagine;
    private static int idCOPrecedente;

    public Contenuto(byte[] immagine, String titolo, String descrizione, String piRiferimento) {
        super(descrizione,titolo,piRiferimento);
        this.immagine=immagine;
        setIdContenuto();
    }

    public Contenuto() {
    }
    public String getIdContenuto() {
        return super.getIdElemento();
    }

    public void setIdContenuto() {
        super.setIdElemento("CO",idCOPrecedente);
        idCOPrecedente +=1;
    }
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }


   /* public void visualizza() throws IOException {
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
        }*/

    public byte[] getImmagine() {
        return immagine;
    }

    public void setImmagine(byte[] immagine) {
        this.immagine = immagine;
    }
}


