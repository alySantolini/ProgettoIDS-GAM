package it.unicam.ProgettoIDS;


import java.util.List;

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

    public void autorizzazione(ListaCondivisaElemento listaCondivisa,String idRichiesta /*controlla commento notifica autorizzazione*/
            , ListaCondivisaElementoPubblicato lCeP){
        Elemento e;
        e = listaCondivisa.getElementoFromId(idRichiesta);
        listaCondivisa.rimuoviElemento(e,this);
        lCeP.aggiungiElemento(e,null,this); //"pubblico" l'elemento
        notificaAutorizzazione(idRichiesta);
    }
    public void gestioneSegnalazione(String idSegnalazione, ListaCondivisaSegnalazioni lista, ListaCondivisaElementoPubblicato lista1){
        Segnalazione s = new Segnalazione();//probabilmente si può scindere in metodi più piccoli
        String idEl = "";// da mettere poi nella classi ListaCondivisaA (LCA) e LCEP
        Elemento e;
        for(int i = 0; i < lista.size(); i++){
            if (Objects.equals(idSegnalazione, lista.get(i).getIdSegnalazione())){
                s = lista.get(i);
                idEl = s.getIdElemento();
            }
        }
        e = lista1.getElementoFromId(idEl); // per il momento do per scontato che ogni segnalazione sia veritiera, quando/se  implementeremo la possibilità
        lista1.rimuoviElemento(e,this); //di avere imput da tastiera il curatore potrà scegliere se eliminare o no l'elemento
        lista.rimuoviSegnalazione(s, this);
        notificaSegnalazione(s.getIdSegnalazione());
    }
    public void pubblicazioneContenuto(Contenuto contenuto){

    }

    public void pubblicazioneEsperienza(Esperienza esperienza){

    }
    public void pubblicazionePI(PI pi){

    }
    public void notificaSegnalazione(String idSegnalazione){ //dovrebbe mandare il messaggio all'utente che ha generato la segnalazione
        System.out.println("resoconto segnalazione: l'elemento da lei segnalato è stato eliminato");//non ho la minima idea di come si faccia scusate
    }
    public void notificaAutorizzazione(String idRichiesta){ //stessa cosa di sopra :< ++ per comodità idRichiesta è l'id dell'elemento creato ed aggiunto alla LCE
        System.out.println("il post è stato pubblicato con successo");
    }

}
