package modelo;

/**
 * Pizza: prato com molho, recheio e borda.
 */
public class Pizza extends Prato {

    private String molho;
    private String recheio;
    private String borda;

    public Pizza(double precoBase, String dataValidade, double peso,
                 String molho, String recheio, String borda) {
        super(precoBase, dataValidade, peso);
        this.molho = molho;
        this.recheio = recheio;
        this.borda = borda;
    }

    /**
     * Retorna o preço base da pizza.
     */
    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }

    // Getters e Setters

    public String getMolho() {
        return molho;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getBorda() {
        return borda;
    }

    public void setBorda(String borda) {
        this.borda = borda;
    }

    @Override
    public String toString() {
        return "[Pizza] " + recheio
                + " | Molho: " + molho
                + " | Borda: " + borda
                + " | " + super.toString();
    }
}
