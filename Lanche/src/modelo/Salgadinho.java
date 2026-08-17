package modelo;

/**
 * Salgadinho: prato com recheio, massa e tipo.
 */
public class Salgadinho extends Prato {

    private String recheio;
    private String massa;
    private String tipo;

    public Salgadinho(double precoBase, String dataValidade, double peso,
                      String recheio, String massa, String tipo) {
        super(precoBase, dataValidade, peso);
        this.recheio = recheio;
        this.massa = massa;
        this.tipo = tipo;
    }

    /**
     * Retorna o preço base do salgadinho.
     */
    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }

    // Getters e Setters

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "[Salgadinho] " + tipo + " de " + recheio
                + " | Massa: " + massa
                + " | " + super.toString();
    }
}
