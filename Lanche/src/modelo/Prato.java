package modelo;

/**
 * Prato genérico abstrato. Define calcularPreco()
 */
public abstract class Prato {

    private double precoBase;
    private String dataValidade;
    private double peso;

    public Prato(double precoBase, String dataValidade, double peso) {
        this.precoBase = precoBase;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }

    /**
     * Retorna o preço final do prato
     */
    public abstract double calcularPreco();

    // Getters e Setters

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("R$ %.2f | Validade: %s | Peso: %.0fg",
                precoBase, dataValidade, peso);
    }
}
