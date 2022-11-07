package ai.quarta;

import java.util.Scanner;

public class Banca {
    private final static int MAX_CONTI = 100;
    private ContoCorrente[] conti;
    private int n_conti;
    public Banca(){
        conti = new ContoCorrente[MAX_CONTI];
        n_conti = 0;
    }
    Scanner in = new Scanner(System.in);

    public boolean creaConto(String nome, String cognome){
        ContoCorrente c = new ContoCorrente(n_conti + 1, nome, cognome);
        conti[n_conti] = c;
        n_conti++;
        return true;
    }

    public int numeroConti(){
        return n_conti;
    }

    public ContoCorrente ricercaPerCognome(String cognome){
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

        for (int i = 0; i < contiCognome.length; i++) {
            System.out.println((i+1)+"-" + contiCognome[i]);
        }

        System.out.println("Quale conto?");
        String scelta = in.nextLine();
        int ss = Integer.parseInt(scelta);

        return contiCognome[ss-1];
    }

    public void mostraConti (){
        for (int i = 0; i < n_conti; i++) {
            System.out.println(conti[i]);
        }
    }
}