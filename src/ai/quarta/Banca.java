package ai.quarta;

public class Banca {
    private final static int MAX_CONTI = 100;
    private ContoCorrente[] conti;
    private int n_conti;

    /**
     * costruttore che crea un vettore di ContoCorrente
     */
    public Banca(){
        conti = new ContoCorrente[MAX_CONTI];
        n_conti = 0;
    }

    /**
     * metodo per la creazione di un nuovo ContoCorrente che viene inserito nel
     * vettore conti
     * @param nome nome del proprietario
     * @param cognome cognome del propietario
     * @return true se l'operazione è riuscita
     */
    public boolean creaConto(String nome, String cognome){
        ContoCorrente c = new ContoCorrente(n_conti + 1, nome, cognome);
        conti[n_conti] = c;
        n_conti++;
        return true;
    }

    public int numeroConti(){
        return n_conti;
    }

    /**
     * metodo per cercare tutti i conti che hanno per cognome la stringa passata per parametro,
     * inserirli in un vettore e ritornare il vettore
     * @param cognome stringa con il cognome da ricercare
     * @return vettore di tipo ContoCorrente
     */
    public ContoCorrente[] ricercaPerCognome(String cognome){
        int contatore = 0;
        for (int i = 0; i < n_conti; i++){
            if (cognome.equals(conti[i].getCognome())){
                contatore++;
            }
        }
        if (contatore == 0){
            System.out.println("Conto inesistente");
            return null;
        }
        ContoCorrente[] contiCognome = new ContoCorrente[contatore];
        int j = 0;
        for (int i = 0; i < n_conti; i++) {
            if (cognome.equals(conti[i].getCognome())){
                contiCognome[j++] = conti[i];
            }
        }
        return contiCognome;
    }

    public ContoCorrente[] mostraConti (){
        return conti;
    }
}