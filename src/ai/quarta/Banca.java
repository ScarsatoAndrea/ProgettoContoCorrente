package ai.quarta;

import java.util.ArrayList;

public class Banca {
    private ArrayList<ContoCorrente> conti;

    private static int nConti = 0;

    private static int setNConti(){
        return ++nConti;
    }

    /**
     * costruttore che crea un vettore di ContoCorrente
     */
    public Banca(){
        conti = new ArrayList<>();
    }

    /**
     * metodo per la creazione di un nuovo ContoCorrente che viene inserito nel
     * vettore conti
     * @param nome nome del proprietario
     * @param cognome cognome del propietario
     * @return true se l'operazione è riuscita
     */
    public boolean creaConto(String nome, String cognome){
        ContoCorrente c = new ContoCorrente(setNConti() + 1, nome, cognome);
        conti.add(c);
        return true;
    }

    public int numeroConti(){
        return conti.size();
    }

    /**
     * metodo per cercare tutti i conti che hanno per cognome la stringa passata per parametro,
     * inserirli in un vettore e ritornare il vettore
     * @param cognome stringa con il cognome da ricercare
     * @return vettore di tipo ContoCorrente
     */
    public ContoCorrente[] ricercaPerCognome(String cognome){
        int contatore = 0;
        ArrayList<ContoCorrente> c = new ArrayList<>();
        for (int i = 0; i < conti.size(); i++){
            if (cognome.equals(conti.get(i).getCognome())){
               c.add(conti.get(i));
            }
        }
        if (c.isEmpty()){
            System.out.println("Conto inesistente");
            return null;
        }

        return (ContoCorrente[]) c.toArray();
    }

    public ContoCorrente[] mostraConti (){
        return (ContoCorrente[]) conti.toArray();
    }
}