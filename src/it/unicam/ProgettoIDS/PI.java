package it.unicam.ProgettoIDS;

public class PI extends Elemento{
    private String idPI;
    private String descrizione;
    private String titolo;
    private String tipologia;
    private String longitudine;
    private String latitudine;
    private static int idPIPrecedente;

    public PI(String descrizione, String titolo, String tipologia, String longitudine, String latitudine) {
        super(descrizione,titolo,tipologia);
        this.longitudine=longitudine;
        this.latitudine=latitudine;

    }
    private void setIdPI(){
        super.setIdElemento("PI", idPIPrecedente);
        idPIPrecedente+=1;
    }

    public String getIdPI() {
        return idPI;
    }


    public void visualizza(){
        if (idPI!=null){
            System.out.println(this.titolo+this.descrizione+this.longitudine+this.latitudine);
        }else{
            System.out.println("Il PI non esiste");
        }
    }
}

