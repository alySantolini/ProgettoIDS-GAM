package it.unicam.ProgettoIDS;

public class PI {
    private String idPI;
    private String descrizione;
    private String titolo;
    private static int idPIPrecedente;

    public PI(String descrizione, String titolo) {
        this.descrizione = descrizione;
        this.titolo = titolo;
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
}

