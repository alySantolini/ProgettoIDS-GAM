# ProgettoIDS-GAM (Giovanni Luciani, Alice Santolini, Marianna Quinzi)

Il progetto riguarda lo sviluppo di una piattaforma interattiva per un determinato comune (per semplicità abbiamo impostato il progetto sul comune di Fano) dove gli utenti possono partecipare attivamente inserendo nuovi contenuti riguardanti i punti di interesse del comune. Ogni utente ha diverse responsabilità e azioni che può eseguire, nel particolare sono stati implementati i ruoli di:
1.	Contributore(autorizzato e non)
2.	Curatore
3.	Turista(autenticato e non)
4.	Animatore
   
Per semplificare le procedure di accesso alle differenti pagine web sono stati caricati nel database i vari tipi di attori (uno per ognuno). 

Per accedere alle varie pagine web (differenziate per attore) bisogna passare attraverso la pagina di login. Le credenziali di accesso sono: username = nickname dell’utente (curatore, animatore, contributoreA, contributore, turistaA, turista) e password= id attore (rispettivamente CU001, A0, CA0, C1, TA0, T1), inoltre per la visualizzazione dell’immagine inserire il path desiderato.

La piattaforma è stata sviluppata attraverso il framework SpringBoot  e si appoggia sul database h2 console (user = user, password = pass).

Ogni classe che necessita di persistenza è stata definita come entità ed inserita nel database. Per ognuna viene creata una tabella in cui viene inserita ogni istanza, in modo che successivamente sia possibile reperirle.

Attraverso il software Visual Paradigm  è stata realizzata la modellazione del progetto con lo sviluppo di 4 iterazioni. Per ogni iterazione sono stati realizzati i diagrammi richiesti (Use-Case, Classi di Analisi, Classi di Progetto, Diagrammi di sequenza). I casi d’uso sviluppati nel software sono caratterizzati da un colore rosa, ma nel codice non sono stati totalmente implementati. 

Nell’implementazione le varie classi sono state divise in tre elementi (Controller, Repository e Service), inoltre è stato implementato il design pattern Factory Method in particolare per la creazione delle classi che estendono Elemento (classe astratta).
