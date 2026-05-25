import java.util.Scanner;

/**
 * Inverter Número
 * Baseado em: Medina & Fertig - "Algoritmos e Programação, Teoria e Prática", 2ª ed., p. 40
 *
 * Versão 1: 4 dígitos fixos
 * Versão 2: N dígitos
 */
public class InverterNumero {

    // Versão 1: exatamente 4 dígitos (fiel ao livro)
    public static int inverterQuatroDigitos(int valorInicial) {
        int valorTemp = valorInicial;

        int milhar  = valorTemp / 1000;
        valorTemp   = valorTemp % 1000;

        int centena = valorTemp / 100;
        valorTemp   = valorTemp % 100;

        int dezena  = valorTemp / 10;
        int unidade = valorTemp % 10;

        return unidade * 1000
             + dezena  * 100
             + centena * 10
             + milhar;
    }

    // Versão 2: N dígitos
    public static long inverterNDigitos(long valorInicial) {
        long valorTemp     = valorInicial;
        long valorInvertido = 0;

        while (valorTemp > 0) {
            long digito    = valorTemp % 10;
            valorInvertido = (valorInvertido * 10) + digito;
            valorTemp      = valorTemp / 10;
        }

        return valorInvertido;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Versão 1: 4 dígitos ===");
        System.out.print("Entre com um número de 4 dígitos: ");
        int numero4 = scanner.nextInt();
        System.out.printf("O número %d invertido é %d%n%n", numero4, inverterQuatroDigitos(numero4));

        System.out.println("=== Versão 2: N dígitos ===");
        System.out.print("Entre com um número inteiro positivo: ");
        long numeroN = scanner.nextLong();
        System.out.printf("O número %d invertido é %d%n", numeroN, inverterNDigitos(numeroN));

        scanner.close();
    }
}