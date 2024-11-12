
/* Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de 12 posições do tipo real.
 Imprima quais valores desses informados são maiores que a média dos valores. Faça um método para ler os valores, 
 outro para calcular a média e outro para informar os valores maiores que a média.*/
import java.util.Scanner;

public class Uni6Exe02 {
    private Uni6Exe02() {
        Scanner teclado = new Scanner(System.in);

        // criar vetor
        final int valorTamanho = 12;
        double valor[] = new double[valorTamanho];

        // ler vetor
        valorLer(valorTamanho, valor, teclado);

        // calcular média
        double media = calculaMedia(valorTamanho, valor);

        // imprimir valores maiores que a média
        imprimeMaioresQueMedia(valorTamanho, valor, media);

        teclado.close();
    }

    // Método para ler os 12 valores e armazenar no vetor
    private void valorLer(int valorTamanho, double valor[], Scanner teclado) {
        for (int i = 0; i < valorTamanho; i++) {
            System.out.print("Valor[" + i + "]: ");
            valor[i] = teclado.nextDouble();
        }
    }

    // Método para calcular a média dos valores no vetor
    private double calculaMedia(int valorTamanho, double valor[]) {
        double soma = 0;
        for (int i = 0; i < valorTamanho; i++) {
            soma += valor[i];
        }
        return soma / valorTamanho;
    }

    // Método para imprimir os valores que são maiores que a média
    private void imprimeMaioresQueMedia(int valorTamanho, double valor[], double media) {
        System.out.println("\nValores maiores que a média (" + media + "):");
        for (int i = 0; i < valorTamanho; i++) {
            if (valor[i] > media) {
                System.out.println("Valor[" + i + "]: " + valor[i]);
            }
        }
    }

    public static void main(String[] args) {
        new Uni6Exe02();
    }
}