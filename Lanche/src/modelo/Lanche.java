package modelo;

/**
 * Lanche: prato com pão, recheio e molho.
 */
public class Lanche extends Prato {

    private String pao;
    private String recheio;
    private String molho;

    public Lanche(double precoBase, String dataValidade, double peso,
                  String pao, String recheio, String molho) {
        super(precoBase, dataValidade, peso);
        this.pao = pao;
        this.recheio = recheio;
        this.molho = molho;
    }

    /**
     * Retorna o preço base do lanche.
     */
    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }

    // Getters e Setters

    public String getPao() {
        return pao;
    }

    public void setPao(String pao) {
        this.pao = pao;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getMolho() {
        return molho;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    @Override
    public String toString() {
        return "[Lanche] " + recheio
                + " | Pao: " + pao
                + " | Molho: " + molho
                + " | " + super.toString();
    }
}
