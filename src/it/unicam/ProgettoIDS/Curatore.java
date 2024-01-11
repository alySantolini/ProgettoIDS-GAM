package it.unicam.ProgettoIDS;



public class Curatore {
    private String idCuratore;
    private String nome;
    private String cognome;
    private String nomeUtente;


    public Curatore(String nome, String cognome, String nomeUtente) {
        this.idCuratore = "CU001";
        this.nome = nome;
        this.cognome = cognome;
        this.nomeUtente = nomeUtente;
    }

    public String getIdCuratore() {
        return idCuratore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public void autorizzazione(ListaCondivisaElemento listaCondivisa,Elemento e){
        List<Elemento> lista = listaCondivisa.getLista();
        System.out.println("elementi della lista : " +lista);
        listaCondivisa.rimuoviElemento(e,this);
    }
    public void gestioneSegnalazione(String idSegnalazione){

    }
    public void pubblicazioneContenuto(Contenuto contenuto){

    }

    public void pubblicazioneEsperienza(Esperienza esperienza){

    }
    public void pubblicazionePI(PI pi){

    }
    public void notificaSegnalazione(String idSegnalazione){

    }
    public void notificaAutorizzazione(String idRichiesta){

    }

}
