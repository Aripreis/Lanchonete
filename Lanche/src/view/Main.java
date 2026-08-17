package view;
import java.util.Scanner;

import modelo.Pedido;
import modelo.Pizza;
import modelo.Salgadinho;
import modelo.Lanche;

/**
 * CLI interativa da Lanchonete Quase Tres Lanches.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Pedido pedidoAtual = null;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("   Quase Tres Lanches - Sistema de Pedidos");
        System.out.println("=============================================");

        menuPrincipal();

        System.out.println();
        System.out.println("Fechando ...");
        scanner.close();
    }

    // ===================== MENU PRINCIPAL =====================

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println();
            System.out.println("=========== MENU PRINCIPAL ===========");
            System.out.println("  1. Criar Novo Pedido");
            System.out.println("  2. Adicionar Item ao Pedido");
            System.out.println("  3. Mostrar Fatura (Nota Fiscal)");
            System.out.println("  4. Calcular Troco");
            System.out.println("  0. Sair");
            System.out.println("======================================");

            opcao = lerOpcao();

            switch (opcao) {
                case 1: criarPedido(); break;
                case 2: adicionarItem(); break;
                case 3: mostrarFatura(); break;
                case 4: calcularTroco(); break;
                case 0: break;
                default: System.out.println("  Opcao invalida!");
            }
        } while (opcao != 0);
    }

    // ===================== CRIAR PEDIDO =====================

    private static void criarPedido() {
        System.out.println();
        System.out.println("--- CRIAR NOVO PEDIDO ---");

        String nome = lerTexto("Nome do cliente");
        double taxa = lerDouble("Taxa de servico (R$)");

        pedidoAtual = new Pedido(nome, taxa);

        System.out.println();
        System.out.println("  Pedido criado para '" + nome + "'!");
    }

    // ===================== ADICIONAR ITENS =====================

    private static void adicionarItem() {
        if (pedidoAtual == null) {
            System.out.println();
            System.out.println("  Nenhum pedido aberto. Crie um pedido primeiro (opcao 1).");
            return;
        }

        System.out.println();
        System.out.println("--- ADICIONAR ITEM ---");
        System.out.println("  Tipo de prato:");
        System.out.println("    1. Pizza");
        System.out.println("    2. Salgadinho");
        System.out.println("    3. Lanche");
        System.out.println("    0. Cancelar");

        int tipo = lerOpcao();

        switch (tipo) {
            case 1: adicionarPizza(); break;
            case 2: adicionarSalgadinho(); break;
            case 3: adicionarLanche(); break;
            case 0: break;
            default: System.out.println("  Opcao invalida!");
        }
    }

    private static void adicionarPizza() {
        System.out.println();
        System.out.println("--- NOVA PIZZA ---");

        double preco = lerDouble("Preco (R$)");
        String validade = lerTexto("Data de validade");
        double peso = lerDouble("Peso (g)");
        String molho = lerTexto("Molho");
        String recheio = lerTexto("Recheio");
        String borda = lerTexto("Borda");

        Pizza pizza = new Pizza(preco, validade, peso, molho, recheio, borda);
        pedidoAtual.adicionarItem(pizza);

        System.out.println();
        System.out.println("  Pizza adicionada: " + pizza);
    }

    private static void adicionarSalgadinho() {
        System.out.println();
        System.out.println("--- NOVO SALGADINHO ---");

        double preco = lerDouble("Preco (R$)");
        String validade = lerTexto("Data de validade");
        double peso = lerDouble("Peso (g)");
        String recheio = lerTexto("Recheio");
        String massa = lerTexto("Massa");
        String tipo = lerTexto("Tipo (ex: Coxinha, Empada, Pastel)");

        Salgadinho salgadinho = new Salgadinho(preco, validade, peso, recheio, massa, tipo);
        pedidoAtual.adicionarItem(salgadinho);

        System.out.println();
        System.out.println("  Salgadinho adicionado: " + salgadinho);
    }

    private static void adicionarLanche() {
        System.out.println();
        System.out.println("--- NOVO LANCHE ---");

        double preco = lerDouble("Preco (R$)");
        String validade = lerTexto("Data de validade");
        double peso = lerDouble("Peso (g)");
        String pao = lerTexto("Pao");
        String recheio = lerTexto("Recheio");
        String molho = lerTexto("Molho");

        Lanche lanche = new Lanche(preco, validade, peso, pao, recheio, molho);
        pedidoAtual.adicionarItem(lanche);

        System.out.println();
        System.out.println("  Lanche adicionado: " + lanche);
    }

    // ===================== MOSTRAR FATURA =====================

    private static void mostrarFatura() {
        if (pedidoAtual == null) {
            System.out.println();
            System.out.println("  Nenhum pedido aberto.");
            return;
        }

        if (pedidoAtual.getItensConsumidos().isEmpty()) {
            System.out.println();
            System.out.println("  Pedido vazio. Adicione itens primeiro (opcao 2).");
            return;
        }

        pedidoAtual.mostrarFatura();
    }

    // ===================== FLUXO C: CALCULAR TROCO =====================

    private static void calcularTroco() {
        if (pedidoAtual == null) {
            System.out.println();
            System.out.println("  Nenhum pedido aberto.");
            return;
        }

        if (pedidoAtual.getItensConsumidos().isEmpty()) {
            System.out.println();
            System.out.println("  Pedido vazio. Adicione itens primeiro.");
            return;
        }

        System.out.println();
        System.out.printf("  Total do pedido: R$ %.2f%n", pedidoAtual.calcularTotal());

        double valorRecebido = lerDouble("Valor recebido do cliente (R$)");
        double troco = pedidoAtual.calcularTroco(valorRecebido);

        System.out.println();
        if (troco >= 0) {
            System.out.printf("  Troco: R$ %.2f%n", troco);
        } else {
            System.out.printf("  Valor insuficiente! Faltam R$ %.2f%n", Math.abs(troco));
        }
    }

    // ===================== METODOS AUXILIARES =====================

    /**
     * Le opcao numerica com prompt.
     */
    private static int lerOpcao() {
        System.out.print("  Opcao: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Le texto com rotulo.
     */
    private static String lerTexto(String campo) {
        System.out.print("  " + campo + ": ");
        return scanner.nextLine().trim();
    }

    /**
     * Le valor double validado.
     */
    private static double lerDouble(String campo) {
        while (true) {
            System.out.print("  " + campo + ": ");
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Valor invalido. Tente novamente.");
            }
        }
    }
}
