package it.unicam.ProgettoIDS;
public class Segnalazione {

    private String idSegnalazione;
    private String descrizione;
    private static int idSPrecedente;
    private String idElemento;


    public Segnalazione( String idElemento,String descrizione) {

        this.descrizione = descrizione;
        this.idElemento=idElemento;
    }

    public String getIdSegnalazione() {
        return idSegnalazione;
    }

    public void setIdSegnalazione(){
        this.idSegnalazione = "S"+idSPrecedente;
        idSPrecedente+=1;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIdElemento(){
        return idElemento;
    }

    public void setIdElemento(String idElemento){
        this.idElemento=idElemento;
    }

}
