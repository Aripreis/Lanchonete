package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Pedido: agrega itens consumidos e calcula total, fatura e troco.
 */
public class Pedido {

    private String nomeCliente;
    private double taxaServico;
    private List<Prato> itensConsumidos;

    public Pedido(String nomeCliente, double taxaServico) {
        this.nomeCliente = nomeCliente;
        this.taxaServico = taxaServico;
        this.itensConsumidos = new ArrayList<>();
    }

    /**
     * Adiciona um item ao pedido.
     */
    public void adicionarItem(Prato item) {
        itensConsumidos.add(item);
    }

    /**
     * Calcula o total usando polimorfismo (calcularPreco em cada Prato).
     */
    public double calcularTotal() {
        double total = 0;
        for (Prato prato : itensConsumidos) {
            total += prato.calcularPreco();
        }
        return total + taxaServico;
    }

    /**
     * Exibe a nota fiscal completa do pedido.
     */
    public void mostrarFatura() {
        System.out.println();
        System.out.println("========== NOTA FISCAL ==========");
        System.out.println("  Cliente: " + nomeCliente);
        System.out.println("---------------------------------");

        for (int i = 0; i < itensConsumidos.size(); i++) {
            Prato p = itensConsumidos.get(i);
            System.out.println("  " + (i + 1) + ". " + p);
        }

        double subtotal = calcularTotal() - taxaServico;
        System.out.println("---------------------------------");
        System.out.printf("  Subtotal:      R$ %.2f%n", subtotal);
        System.out.printf("  Taxa Servico:  R$ %.2f%n", taxaServico);
        System.out.printf("  TOTAL:         R$ %.2f%n", calcularTotal());
        System.out.println("=================================");
    }

    /**
     * Calcula o troco a partir do valor recebido.
     */
    public double calcularTroco(double valorRecebido) {
        return valorRecebido - calcularTotal();
    }

    // Getters

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    public List<Prato> getItensConsumidos() {
        return itensConsumidos;
    }
}
