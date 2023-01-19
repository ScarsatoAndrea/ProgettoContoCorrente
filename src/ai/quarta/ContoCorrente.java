package ai.quarta;

import java.util.ArrayList;

public class ContoCorrente {
    private int numeroConto;
    private String nome;
    private String cognome;
    private float saldo;
    private ArrayList<Movimento> movimenti;

    /**
     * costruttore della classe ContoCorrente che crea un nuovo conto, impostando dei valori
     * passati per parametri e altri no
     * saldo viene settato a 0
     * viene creato un nuovo vettore di movimenti attualmente vuoto (n_movimenti = 0)
     * @param numeroConto viene impostato alla posizione nel vettore (nella classe Banca) +1
     * @param nome nome del propietario
     * @param cognome cognome del propietario
     */
    public ContoCorrente(int numeroConto, String nome, String cognome) {
        this.numeroConto = numeroConto;
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = 0;
        this.movimenti = new ArrayList<Movimento>();
    }

    /**
     * metodo per il deposito di una somma di denaro, crea un nuovo oggetto di
     * tipo Movimento e lo mette nell'arrylist di movimenti
     * @param importo somma depositata
     * @param descrizione motivo del deposito
     */
    public void deposita (float importo, String descrizione){
        movimenti.add(new Movimento(descrizione, importo));
        saldo += importo;
    }

    /**
     * metodo per il prelievo di una somma di denaro, crea un nuovo oggetto di
     * tipo Movimento e lo mette nel vettore movimenti
     * @param importo somma prelevata
     * @param descrizione motivo del prelievo
     */
    public void preleva (float importo, String descrizione){
        if (importo > saldo){
            System.out.println("Saldo insufficiente");
        }
        else{
            movimenti.add(new Movimento(descrizione, -importo));
            saldo -= importo;
        }
    }

    public Movimento[] mostraMovimenti (){
        return movimenti.toArray(new Movimento[1]);
    }

    public String getCognome() {
        return cognome;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    @Override
    public String toString() {
        return "'" + nome + '\'' +
                ", '" + cognome + '\'' +
                ", numero conto: " + numeroConto +
                ", saldo corrente: " + saldo;
    }
}