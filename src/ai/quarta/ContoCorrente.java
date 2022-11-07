package ai.quarta;

public class ContoCorrente {
    private int numeroConto;
    private String nome;
    private String cognome;
    private float saldo;

    private Movimento[] movimenti;

    private int n_movimenti;

    private static final int MAX_MOVIMENTI = 100;

    public ContoCorrente(int numeroConto, String nome, String cognome) {
        this.numeroConto = numeroConto;
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = 0;
        this.movimenti = new Movimento[MAX_MOVIMENTI];
        this.n_movimenti = 0;
    }

    public void deposita (float importo, String descrizione){
        movimenti[n_movimenti] = new Movimento(descrizione, importo);
        saldo += importo;
        n_movimenti++;
    }

    public void preleva (float importo, String descrizione){
        if (importo > saldo){
            movimenti[n_movimenti] = new Movimento(descrizione, -importo);
            System.out.println("Saldo insufficiente");
        }
        else{
            saldo -= importo;
            n_movimenti++;
        }
    }

    public void mostraMovimenti (){
        for (int i = 0; i < n_movimenti; i++) {
            System.out.println(movimenti[i]);
        }
    }

    public String getCognome() {
        return cognome;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    @Override
    public String toString() {
        return "ContoCorrente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}