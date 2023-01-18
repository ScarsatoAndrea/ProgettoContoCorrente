/**
 * Programma per la gestione di un conto corrente
 *
 * @author Scarsato Andrea
 * @version 1.3 18/01/2023
 */

import ai.quarta.Banca;
import ai.quarta.ContoCorrente;
import ai.quarta.Movimento;

import java.util.Scanner;

public class Main {
    /**
     * inserimento dati in una banca per fare delle prove
     * @param b l'oggetto banca
     */
    static void datiStub(Banca b){
        b.creaConto("Piero", "Paletti");
        b.creaConto("Silvia", "Ardicci");
        b.creaConto("Luisa", "Perloni");
        b.creaConto("Giovanni", "Paletti");

    }

    /**
     * mostra tutti i conti presenti nella banca
     * @param b banca da cui prende i conti
     */
    static void mostraConti (Banca b){
        ContoCorrente[] a;
        a = b.mostraConti();
        int i = 0;
        while(a[i] != null){
            System.out.println(a[i]);
            i++;
        }
    }

    /**
     * attraverso una ricerca per cognome trova l'oggetto conto corrente dentro banca
     * che ha quel cognome
     * @param b la banca dentro la quale cerca il conto
     * @param cognome il cognome del "propietario" del conto
     * @return ritorna l'oggetto contocorrente con il cognome che cercavamo
     */
    static ContoCorrente selezionaConto (Banca b, String cognome){
        Scanner in = new Scanner(System.in);
        ContoCorrente[] c;
        c = b.ricercaPerCognome(cognome);
        for (int i = 0; i < c.length; i++) {
            System.out.println((i+1)+"-" + c[i]);
        }

        System.out.println("Quale conto?");
        String scelta = in.nextLine();
        int ss = Integer.parseInt(scelta);
        return c[ss-1];
    }

    /**
     * mostra i movimenti di un oggetto conto corrente
     * @param c l'oggetto di tipo contocorrenti di cui vogliamo vedere
     *          i movimenti
     */
    static void mostraMovimenti (ContoCorrente c){
        Movimento[] m;
        m = c.mostraMovimenti();
        int i = 0;
        while(m[i] != null){
            System.out.println(m[i]);
            i++;
        }
    }

    public static void main(String[] args) {
        Banca b = new Banca();
        datiStub(b);
        System.out.println(b.numeroConti());

        Scanner in = new Scanner(System.in);
        ContoCorrente a;

        int scelta = -1;
        while (scelta != 0){
            /**
             * le seguenti due linee servono per pulire la console
             * (N.B. non funzione nell'ide)
             */
            System.out.print("\033[H\033[2J");
            System.out.flush();

            /**
             * menù con le diverse opzioni
             */
            System.out.println("Scegli cosa vuoi fare: \n" +
                    "1-cercare un conto\n" +
                    "2-creare un conto\n" +
                    "3-visualizza elenco conti\n"+
                    "0-uscire");

            String temp = in.nextLine();
            scelta = Integer.parseInt(temp);

            if (scelta == 1){
                System.out.println("Inserisci il cognome del prorpietario: ");
                String cognome = in.nextLine();
                a = selezionaConto(b, cognome);

                System.out.print("\033[H\033[2J");
                System.out.flush();

                int scelta2 = -1;
                while(scelta2 != 4 && scelta2 != 0){
                    System.out.println(a);
                    System.out.println("Cosa vuoi fare?\n" +
                            "1-preleva\n" +
                            "2-deposita\n" +
                            "3-visualizza movimenti\n" +
                            "4-torna indietro\n");

                    temp = in.nextLine();
                    scelta2 = Integer.parseInt(temp);
                    if (scelta2==1){
                        System.out.println("Quantità da prelevare: ");
                        temp = in.nextLine();
                        float tempo = Float.parseFloat(temp);
                        System.out.println("Motivo del prelievo?");
                        String desc = in.nextLine();
                        a.preleva(tempo, desc);
                    }
                    else if (scelta2 == 2){
                        System.out.println("Quantità da depositare: ");
                        temp = in.nextLine();
                        float tempo = Float.parseFloat(temp);
                        System.out.println("Motivo del deposito?");
                        String desc = in.nextLine();
                        a.deposita(tempo, desc);
                    }
                    else if (scelta2 == 3){
                        mostraMovimenti(a);
                    }
                }
            }

            else if (scelta == 2){
                System.out.println("Inserisci il nome:");
                String nome = in.nextLine();
                System.out.println("Inserisci il cognome:");
                String cogn = in.nextLine();
                b.creaConto(nome, cogn);
            }

            else if (scelta == 3){
                mostraConti(b);
            }

            else{
                /**
                 * crediti
                 */
                System.out.println("Grazie per aver usato questo software, per maggiori info sull" + '\'' + "autore\n" +
                        "ig: https://www.instagram.com/andrea.ska\n" +
                        "github: https://github.com/ScarsatoAndrea");
            }
        }
    }
}