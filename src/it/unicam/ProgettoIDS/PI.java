package it.unicam.ProgettoIDS;

public class PI {
    private String idPI;
    private String descrizione;
    private String titolo;
    private String longitudine;
    private String latitudine;
    private static int idPIPrecedente;

    public PI(String descrizione, String titolo,String longitudine,String latitudine) {
        this.descrizione = descrizione;
        this.titolo = titolo;
        this.longitudine=longitudine;
        this.latitudine=latitudine;

    }
    private void setIdPI(){
        this.idPI = "PI" + idPIPrecedente;
        idPIPrecedente+=1;
    }

    public String getIdPI() {
        return idPI;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void visualizza(){
        if (idPI!=null){
            System.out.println(this.titolo+this.descrizione+this.longitudine+this.latitudine);
        }else{
            System.out.println("Il PI non esiste");
        }
    }
}

