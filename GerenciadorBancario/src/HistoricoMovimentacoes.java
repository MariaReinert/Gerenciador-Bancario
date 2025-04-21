import java.util.ArrayList;
import java.util.Scanner;
public class HistoricoMovimentações {
}
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> contas = new ArrayList<>();
    ArrayList<Double> saldos = new ArrayList<>();
    ArrayList<String> historicos = new ArrayList<>();

    while (true) {
        System.out.println("\n===== MENU BANCÁRIO =====");
        System.out.println("1 - Cadastrar conta");
        System.out.println("2 - Realizar depósito");
        System.out.println("3 - Realizar saque");
        System.out.println("4 - Consultar saldo");
        System.out.println("5 - Consultar histórico de movimentações");
        System.out.println("6 - Transferir entre contas");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        if (opcao == 1) {
            System.out.print("Nome da conta: ");
            String nome = scanner.nextLine();
            contas.add(nome);
            saldos.add(0.0);
            historicos.add("Conta criada com saldo R$ 0.0\n");
            System.out.println("Conta cadastrada com sucesso!");
        }

        else if (opcao == 2) {
            System.out.print("Nome da conta: ");
            String nome = scanner.nextLine();
            int index = contas.indexOf(nome);
            if (index != -1) {
                System.out.print("Valor do depósito: ");
                double valor = scanner.nextDouble();
                saldos.set(index, saldos.get(index) + valor);
                historicos.set(index, historicos.get(index) + "Depósito de R$ " + valor + "\n");
                System.out.println("Depósito realizado!");
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        else if (opcao == 3) {
            System.out.print("Nome da conta: ");
            String nome = scanner.nextLine();
            int index = contas.indexOf(nome);
            if (index != -1) {
                System.out.print("Valor do saque: ");
                double valor = scanner.nextDouble();
                if (valor <= saldos.get(index)) {
                    saldos.set(index, saldos.get(index) - valor);
                    historicos.set(index, historicos.get(index) + "Saque de R$ " + valor + "\n");
                    System.out.println("Saque realizado!");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        else if (opcao == 4) {
            System.out.print("Nome da conta: ");
            String nome = scanner.nextLine();
            int index = contas.indexOf(nome);
            if (index != -1) {
                System.out.println("Saldo: R$ " + saldos.get(index));
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        else if (opcao == 5) {
            System.out.print("Nome da conta: ");
            String nome = scanner.nextLine();
            int index = contas.indexOf(nome);
            if (index != -1) {
                System.out.println("Histórico:");
                System.out.println(historicos.get(index));
            } else {
                System.out.println("Conta não encontrada.");
            }
        }
    }
}


