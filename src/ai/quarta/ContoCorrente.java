package ai.quarta;

import java.util.ArrayList;

public class ContoCorrente {
    private int numeroConto;
    private String nome;
    private String cognome;
    private float saldo;
    private boolean bloccato;
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
        this.bloccato = false;
        this.movimenti = new ArrayList<Movimento>();
    }

    /**
     * metodo per il deposito di una somma di denaro, crea un nuovo oggetto di
     * tipo Movimento e lo mette nell'arrylist di movimenti
     * @param importo somma depositata
     * @param descrizione motivo del deposito
     */
    public void deposita (float importo, String descrizione) throws ContoBloccatoException {
        if (bloccato)
            throw new ContoBloccatoException();
        movimenti.add(new Movimento(descrizione, importo));
        saldo += importo;
    }

    /**
     * metodo per il prelievo di una somma di denaro, crea un nuovo oggetto di
     * tipo Movimento e lo mette nel vettore movimenti
     * @param importo somma prelevata
     * @param descrizione motivo del prelievo
     */
    public void preleva (float importo, String descrizione) throws ContoBloccatoException, SaldoNegativoException {
        saldo -= importo;
        if (bloccato)
            throw new ContoBloccatoException();
        if (saldo <= -100){
           throw new SaldoNegativoException(importo);
        }
        else{
            movimenti.add(new Movimento(descrizione, -importo));
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

    public void bloccaConto() {
        bloccato = true;
        movimenti.add(new Movimento("conto bloccato", 0000.0f));
    }

    public void sbloccaConto() {
        bloccato = false;
        movimenti.add(new Movimento("conto sbloccato", 0000.0f));
        saldo = 0;
    }

    @Override
    public String toString() {
        String s = "'" + nome + '\'' +
                ", '" + cognome + '\'' +
                ", numero conto: " + numeroConto +
                ", saldo corrente: " + saldo;
        if (bloccato)
            s += ", conto bloccato";
        return s ;
    }
}