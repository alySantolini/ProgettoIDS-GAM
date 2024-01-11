package it.unicam.ProgettoIDS;

public class ContributoreAutorizzato {

    private String idContributore;
    private String nome;
    private String cognome;
    private String nomeUtente;
    private static int idCAPrecedente;

    public ContributoreAutorizzato(String nome, String cognome, String nomeUtente) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeUtente = nomeUtente;
        setIdContributore();
    }

    public String getIdContributore() {
        return idContributore;
    }

    private void setIdContributore() {
        this.idContributore = "CA" + idCAPrecedente;
        idCAPrecedente +=1;
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
