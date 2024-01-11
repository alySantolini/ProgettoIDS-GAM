import it.unicam.ProgettoIDS.Contributore;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        // Press Alt+Invio with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        File file = new File ("/C:/Users/Alice/Desktop/perlana.jpg/");
        Image image = ImageIO.read(file);
        Contributore contributore = new Contributore("alberto","ciao","albiCiao");
        contributore.creaContenuto(null,"perlana","lavatoCon");
        contributore.creaContenuto(file,"perlana","lavatoCon").visualizza();
        contributore.creaContenuto(null,"perlana","lavatoCon").visualizza();
    }
}
