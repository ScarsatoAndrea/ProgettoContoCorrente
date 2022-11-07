/**
 * Programma per la gestione di un conto corrente
 *
 * @author Scarsato Andrea
 * @version 1.1 04/11/2022
 */

import ai.quarta.Banca;
import ai.quarta.ContoCorrente;
import java.util.Scanner;

public class Main {
    static void datiStub(Banca b){
        b.creaConto("Piero", "Paletti");
        b.creaConto("Silvia", "Ardicci");
        b.creaConto("Luisa", "Perloni");
        b.creaConto("Giovanni", "Paletti");

    }

    public static void main(String[] args) {
        Banca b = new Banca();
        datiStub(b);
        System.out.println(b.numeroConti());

        ContoCorrente a;
        Scanner in = new Scanner(System.in);

        int scelta = 0;
        while (scelta != -1){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Scegli cosa vuoi fare: \n" +
                    "1-cercare un conto\n" +
                    "2-creare un conto\n" +
                    "3-visualizza elenco conti\n"+
                    "-1-uscire");

            String temp = in.nextLine();
            scelta = Integer.parseInt(temp);

            if (scelta == 1){
                System.out.println("Inserisci il cognome del prorpietario: ");
                String cognome = in.nextLine();
                a = b.ricercaPerCognome(cognome);
                System.out.print("\033[H\033[2J");
                System.out.flush();

                int scelta2 = 0;
                while(scelta2 != 4 && scelta2 != -1){
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
                        int tempo = Integer.parseInt(temp);
                        System.out.println("Motivo del prelievo?");
                        String desc = in.nextLine();
                        a.preleva(tempo, desc);
                    }
                    else if (scelta2 == 2){
                        System.out.println("Quantità da depositare: ");
                        temp = in.nextLine();
                        int tempo = Integer.parseInt(temp);
                        System.out.println("Motivo del deposito?");
                        String desc = in.nextLine();
                        a.deposita(tempo, desc);
                    }
                    else if (scelta2 == 3){
                        a.mostraMovimenti();
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
                b.mostraConti();
            }

            else{
                System.out.println("Grazie per aver usato questo software, per maggiori info sull" + '\'' + "autore\n" +
                        "ig: https://www.instagram.com/andrea.ska\n" +
                        "github: https://github.com/ScarsatoAndrea");
            }
        }
    }
}