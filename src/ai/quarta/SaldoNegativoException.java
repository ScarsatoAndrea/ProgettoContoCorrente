package ai.quarta;

public class SaldoNegativoException extends Exception {
    private float importo;

    public SaldoNegativoException(float importo) {
        this.importo = importo;
    }

    public float getImporto() {
        return importo;
    }

    @Override
    public String toString() {
        return "SaldoNegativoException{" +
                "importo=" + importo +
                '}';
    }
}
