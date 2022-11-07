package ai.quarta;
import java.time.LocalDateTime;

public class Movimento {
    private String descrizione;
    private float importo;
    private LocalDateTime data;

    /**
     * costruttore della classe Movimento
     * @param descrizione motivo dell'operazione
     * @param importo importo dell'operazione, può essere sia positivo
     *                che negativo
     * @param data viene passata per parametro, deve essere un oggetto
     *             della classe LocalDateTime
     */
    public Movimento(String descrizione, float importo, LocalDateTime data) {
        this.descrizione = descrizione;
        this.importo = importo;
        this.data = data;
    }

    /**
     * costruttore alternativo simile al precedente ma senza la data nei
     * parametri (viene impostata nel costruttore)
     * @param descrizione motivo dell'operazione
     * @param importo importo dell'operazione, può essere sia positivo
     *               che negativo
     */
    public Movimento(String descrizione, float importo){
        this.descrizione = descrizione;
        this.importo = importo;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if (importo > 0)
            return data + "  " + descrizione + "  " + "+" +importo;
        return data + "  " + descrizione + "  " + importo;
    }
}