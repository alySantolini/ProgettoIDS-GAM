package it.unicam.ProgettoIDS;

public class ContributoreAutorizzato {

    private String idContributore;
    private String nome;
    private String cognome;
    private String nomeUtente;
    private int idPrecedente=000;

    public ContributoreAutorizzato(String idContributore, String nome, String cognome, String nomeUtente) {
        this.idContributore = idContributore;
        this.nome = nome;
        this.cognome = cognome;
        this.nomeUtente = nomeUtente;
    }

    public String getIdContributore() {
        return idContributore;
    }

    public void setIdContributore(String idContributore) {
        this.idContributore = "CA" + idPrecedente;
        idPrecedente +=1;
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

    public void pubblicazioneContenuto(Contenuto contenuto){

    }

    public void pubblicazioneEsperienza(Esperienza esperienza){

    }
    public void pubblicazionePI(PI pi){

    }
    public Segnalazione creaSegnalazione(Elemento e){

        return null;
    }

}
